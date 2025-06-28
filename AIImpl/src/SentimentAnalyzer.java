import okhttp3.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SentimentAnalyzer {
    private static final String API_URL = "https://api.mistral.ai/v1/chat/completions";
    private static final String API_KEY = "luVZdb82vL7eCiuNstjaG56VK8eqRpGx";  // Replace with your API key

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a review/comment:");
        String userInput = "C:/Users/kanna/eclipseEE-workspace/ResumesFolder/KaviyarasanResume.pdf";
        
        String resumeText = extractTextFromPDF(userInput);
        boolean run = true;
        while(run)
        {
        	System.out.println("1.Enter Query \n2.Exit");
        	int choice = scanner.nextInt();
        	scanner.nextLine();
        	switch(choice)
        	{
        	case 1 :
        		String query = scanner.nextLine();
        		String response = analyzeSentiment(query);
        		
                System.out.println("AI Analysis: " + response);
                break;
                
        	case 2 :
        		run = false;
        		break;
        		
        	default : 
        		System.out.println("Please enter valid choice.");
        	}
        }
    }

    private static String extractTextFromPDF(String filePath) {
    	try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading PDF file";
        }
	}

	private static String analyzeSentiment(String text) {
        OkHttpClient client = new OkHttpClient();

        String prompt =  text;

        JSONObject requestBodyJson = new JSONObject();
        requestBodyJson.put("model", "mistral-tiny");
        requestBodyJson.put("messages", new org.json.JSONArray()
                .put(new JSONObject().put("role", "user").put("content", prompt)));
        requestBodyJson.put("max_tokens", 1000);

        Request request = new Request.Builder()
                .url(API_URL)
                .post(RequestBody.create(requestBodyJson.toString(), MediaType.get("application/json")))
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return "API request failed: " + response.code() + " - " + response.message() + " - " + response.body().string();
            }
            JSONObject jsonResponse = new JSONObject(response.body().string());
            return jsonResponse.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
        } catch (IOException e) {
            return "Error making API call: " + e.getMessage();
        }
    }
}