package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/library";
	private static final String USER = "root";
	private static final String PASSWORD = "1919";
	
	public static Connection getConnection()
	{
		try {
			return DriverManager.getConnection(URL,USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getCountryCode(String code) {
		Connection connection = getConnection();
		String query = "SELECT ID,CODE FROM COUNTRY_CODE WHERE CODE = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setString(1, code);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return resultSet.getInt("ID");
			}
			return 0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static int getPostCode(String post, long pinCode) {
		
		Connection connection = getConnection();
		String query = "SELECT ID,PIN_CODE,NAME FROM POST WHERE NAME = ? AND PIN_CODE = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setString(1, post);
			preparedStatement.setLong(2, pinCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return resultSet.getInt("ID");
			}
			return 0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static int getDistrictCode(String district) {
		Connection connection = getConnection();
		String query = "SELECT ID, NAME FROM DISTRICT WHERE NAME = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setString(1, district);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return resultSet.getInt("ID");
			}
			return 0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
		finally 
		{
			try 
			{
				connection.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static boolean mobileNumberIsFound(long mobileNumber) {
		Connection connection = getConnection();
		String query = "SELECT MOBILE_NUMBER FROM USERS WHERE MOBILE_NUMBER = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setLong(1, mobileNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
