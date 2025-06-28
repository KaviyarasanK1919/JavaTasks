package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnection.DBConnection;
import model.User;

public class UserDao {
	public static User getUserDetails(int id, String password)
	{
		Connection connection = DBConnection.getConnection();
		String query = "SELECT USERS.ID,USERS.USER_ID, USERS.NAME, USERS.MOBILE_NUMBER, COUNTRY_CODE.CODE, USERS.PASSWORD, USERS.ROLE, USERS.PLACE, POST.NAME, POST.PIN_CODE, DISTRICT.NAME FROM USERS"
				+ " INNER JOIN COUNTRY_CODE ON USERS.COUNTRY_CODE_ID = COUNTRY_CODE.ID"
				+ " INNER JOIN POST ON USERS.POST_ID = POST.ID"
				+ " INNER JOIN DISTRICT ON USERS.DIST_ID = DISTRICT.ID"
				+ " WHERE USERS.ID = ? AND USERS.PASSWORD = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
					User user = new User(0,null,null,0,null,null,null,null,null,0,null);
					user.setId(resultSet.getInt("USERS.ID"));
					user.setUserID(resultSet.getString("USERS.USER_ID"));
					user.setName(resultSet.getString("USERS.NAME"));
					user.setMobileNumber(resultSet.getLong("USERS.MOBILE_NUMBER"));
					user.setCounrtyCode(resultSet.getString("COUNTRY_CODE.CODE"));
					user.setPassword(resultSet.getString("USERS.PASSWORD"));
					user.setRole(resultSet.getString("USERS.ROLE"));
					user.setPlace(resultSet.getString("USERS.PLACE"));
					user.setPost(resultSet.getString("POST.NAME"));
					user.setPinCode(resultSet.getLong("POST.PIN_CODE"));
					user.setDistrict(resultSet.getString("DISTRICT.NAME"));
					
					System.out.println(user.getName());
				
					return user;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
}
