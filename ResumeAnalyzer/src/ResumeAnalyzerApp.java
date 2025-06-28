import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
;

public class ResumeAnalyzerApp {
	private static final String API_URL = "https://api.mistral.ai/v1/chat/completions";
    private static final String API_KEY = "luVZdb82vL7eCiuNstjaG56VK8eqRpGx";  // Replace with your API key
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String folderPath = "C:/Users//kanna/eclipseEE-workspace/ResumesFolder";
			Map<String , String> resumeData = new HashMap<>();
			
			resumeData = processResumes(folderPath);
			
			ObjectMapper objectMapper = new ObjectMapper();
	        String jsonData = objectMapper.writeValueAsString(resumeData);
			while(true)
			{
				String responce = analyzeResume(jsonData);
				if(responce.equals("Exit"))
				{
					break;
				}
				System.out.println(responce);
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Error ");
		}
	}

	private static String analyzeResume(String resumeData) {
		OkHttpClient client = new OkHttpClient();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Query : ");
		String query = scan.nextLine();
		
		String prompt = "Analyze this resume and extract the following details:\n" +
                "1. Full Name\n" +
                "2. Mobile Number\n" +
                "3. Email Address\n" +
                "4. Skills\n\n"  + resumeData  + "\n" + query;
		
		JSONObject requestBodyJson = new JSONObject();
		
		requestBodyJson.put("model", "mistral-tiny");
		requestBodyJson.put("messages", new org.json.JSONArray()
				.put(new JSONObject().put("role","user").put("content", prompt)));
		requestBodyJson.put("max_tokens", 10000);
		
		Request request = new Request.Builder()
				.url(API_URL)
				.post(RequestBody.create(requestBodyJson.toString(), MediaType.get("application/json")))
				.addHeader("Authorization", "Bearer " + API_KEY)
				.addHeader("Content-Type","application/json")
				.build();
		
		try(Response response = client.newCall(request).execute())
		{
			if(!response.isSuccessful())
			{
				return "API failed : " + response.message() + " - " + response.code() + " - " +  response.message();
			}
			JSONObject jsonResponse = new JSONObject(response.body().string());
			
			return jsonResponse.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
		}
		catch(IOException e)
		{
			System.out.println("Error making API call : " + e.getMessage());
			return null;
		}
	}

	private static Map<String, String> processResumes(String folderPath) {
		Map<String , String> resumeData = new HashMap<>();
		
		File folder = new File(folderPath);
		if(!folder.exists() || !folder.isDirectory())
		{
			System.out.println("In this directory no folder is not found.");
			return null;
		}
		File [] pdfFiles = folder.listFiles((dir, name) ->  name.toLowerCase().endsWith(".pdf"));
		
		if(pdfFiles.length == 0 || pdfFiles.length == 0)
		{
			System.out.println("No PDF resumes found.");
			return resumeData;
		}
		
		for(File pdfFile : pdfFiles)
		{
			String text = extractTextFromPDF(pdfFile);
			if(text != null)
			{
				resumeData.put(pdfFile.getName(), text);
			}
		}
		return resumeData;
	}

	private static String extractTextFromPDF(File pdfFile) {
		try
		{
			PDDocument document = PDDocument.load(pdfFile);
			PDFTextStripper pdfTextStripper = new PDFTextStripper();
			return pdfTextStripper.getText(document);
		}
		catch(IOException e)
		{
			System.err.println("Error while processing text : "+ pdfFile.getName());
			e.printStackTrace();
			return null;
		}
	}

}
