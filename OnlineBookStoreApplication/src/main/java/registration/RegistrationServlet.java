package registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import dbconnection.DBConnection;
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String USER_KEY_WORD= "USER-KK-";
	private static final String ADMIN_KEY_WORD = "ADM-KK-";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobileNumber");
		String country = request.getParameter("countryCode");
		String password = request.getParameter("password");
		String post = request.getParameter("post");
		String place = request.getParameter("place");
		String district = request.getParameter("district");
		String pin = request.getParameter("pinCode");
		long pinCode = Long.valueOf(pin);
		
		long mobileNumber = Long.valueOf(mobile);
		if(DBConnection.mobileNumberIsFound(mobileNumber))
		{
			request.setAttribute("message", "This Mobile Number is Already Found.");
			request.getRequestDispatcher("view/login/RegisterJsp.jsp").forward(request, response);
			return;
		}
		int countryCodeID = DBConnection.getCountryCode(country);
		int postCodeID = DBConnection.getPostCode(post, pinCode);
		int districtID = DBConnection.getDistrictCode(district);
		String userID = (LoginServlet.isAdmin == true ? ADMIN_KEY_WORD : USER_KEY_WORD)+ getID();
		
		
		Connection connection = DBConnection.getConnection();
		
		String query = "INSERT INTO USERS(USER_ID, NAME, MOBILE_NUMBER, COUNTRY_CODE_ID, PASSWORD, PLACE, POST_ID, DIST_ID) VALUE(?,?,?,?,?,?,?,?)";
		try(PreparedStatement prepareStatement = connection.prepareStatement(query))
		{
			prepareStatement.setString(1, userID);
			prepareStatement.setString(2, name);
			prepareStatement.setLong(3, mobileNumber);
			prepareStatement.setInt(4, countryCodeID);
			prepareStatement.setString(5, password);
			prepareStatement.setString(6, place);
			prepareStatement.setInt(7, postCodeID);
			prepareStatement.setInt(8, districtID);
			System.out.println("Registered");
			
			int value = prepareStatement.executeUpdate();
			if(value > 0)
			{
				request.setAttribute("message", "Successfully Registered. UserID : "+userID+".");
				request.getRequestDispatcher("view/login/RegisterJsp.jsp").forward(request, response);
			}
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.write("Duplicate Entry");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public int getID() throws IOException {
		File file = new File("C:\\Users\\kanna\\eclipseEE-workspace\\OnlineBookStoreApplication\\tex.txt");
		int temp = 100;
		if(!file.exists())
		{
			FileWriter writer = new FileWriter(file);
			writer.write(String.valueOf(temp));
			writer.close();
		}
		else
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
	        temp = Integer.parseInt(reader.readLine());
	        reader.close();
		}
		
		FileWriter writer = new FileWriter(file);
		int value = temp + 1;
		writer.write(String.valueOf(value));
		writer.close();
		return temp;
	}

}
