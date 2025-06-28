package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DBConnection;
import model.Product;
public class ProductDao {
	
	public List<Product> getAllProduts()
	{
		List<Product> books = new ArrayList<>();
		String query = "SELECT * FROM BOOKS";
		Connection connection = DBConnection.getConnection();
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product row = new Product(0,0,null,null, null,null);
				row.setAuthorName(resultSet.getString("AUTHOR_NAME"));
				row.setBookName(resultSet.getString("BOOK_NAME"));
				row.setCategory(resultSet.getString("CATEGORY"));
				row.setId(resultSet.getInt("ID"));
				row.setPrice(resultSet.getInt("PRICE"));
				row.setImageLink(resultSet.getString("IMAGE_LINK"));
				books.add(row);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return books;
	}
	public Product getSingeProduct(int bookID)
	{
		String query = "SELECT * FROM BOOKS WHERE ID = ?";
		Connection connection = DBConnection.getConnection();
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setInt(1, bookID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Product row = new Product(0,0,null,null, null,null);
				row.setAuthorName(resultSet.getString("AUTHOR_NAME"));
				row.setBookName(resultSet.getString("BOOK_NAME"));
				row.setCategory(resultSet.getString("CATEGORY"));
				row.setId(resultSet.getInt("ID"));
				row.setPrice(resultSet.getInt("PRICE"));
				row.setImageLink(resultSet.getString("IMAGE_LINK"));
				System.out.println(row.getImageLink());
				return row;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> getCategoryViceProducts(String category)
	{
		Connection connection = DBConnection.getConnection();
		String query = "SELECT * FROM BOOKS WHERE CATEGORY = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setString(1, category);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Product> books = new ArrayList<>();
			while(resultSet.next())
			{
				Product row = new Product(0,0,null,null, null,null);
				row.setAuthorName(resultSet.getString("AUTHOR_NAME"));
				row.setBookName(resultSet.getString("BOOK_NAME"));
				row.setCategory(resultSet.getString("CATEGORY"));
				row.setId(resultSet.getInt("ID"));
				row.setPrice(resultSet.getInt("PRICE"));
				row.setImageLink(resultSet.getString("IMAGE_LINK"));
				books.add(row);
			}
			return books;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
