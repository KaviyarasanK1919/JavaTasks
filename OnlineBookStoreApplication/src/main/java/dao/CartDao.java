package dao;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dbconnection.DBConnection;
import jakarta.servlet.RequestDispatcher;
import model.Product;

public class CartDao {
	public List<Product> getAllCartIdems(int userID)
	{
		String query = "SELECT BOOKS.BOOK_NAME, BOOKS.IMAGE_LINK, BOOKS.ID,BOOKS.PRICE, CART.QUANTITY FROM CART"
				+ " INNER JOIN BOOKS ON CART.BOOK_ID = BOOKS.ID"
				+ " INNER JOIN USERS ON CART.USER_ID = USERS.ID"
				+ " WHERE CART.USER_ID = ?";
		
		Connection connection = DBConnection.getConnection();
		List<Product> cartIdems = new ArrayList<>();
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setInt(1, userID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product p = new Product();
				
				p.setBookName(resultSet.getString("BOOKS.BOOK_NAME"));
				p.setImageLink(resultSet.getString("BOOKS.IMAGE_LINK"));
				System.out.println(p.getImageLink());
				p.setQuantity(resultSet.getInt("CART.QUANTITY"));
				p.setId(resultSet.getInt("BOOKS.ID"));
				p.setPrice(resultSet.getInt("BOOKS.PRICE"));
				
				cartIdems.add(p);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cartIdems;
	}
	public void removeBookInCart(int id)
	{
		String query = "DELETE FROM CART WHERE ID = ?";
		Connection connection = DBConnection.getConnection();
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setInt(1, id);
			 int val = preparedStatement.executeUpdate();
			 if(val > 0)
			 {
				 System.out.println("Removed");
			 }
			 else
			 {
				 System.out.println("Remove when fails");
			 }
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	 public int getCartID(int userID, int bookID) {
		String query = "SELECT * FROM CART WHERE USER_ID = ? AND BOOK_ID = ?";
		Connection connection = DBConnection.getConnection();
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setInt(1, userID);
			preparedStatement.setInt(2, bookID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return resultSet.getInt("ID");
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public static boolean addBookToCart(int userID, int bookID) {
		
		Connection connection = DBConnection.getConnection();
		String query = "SELECT USER_ID, BOOK_ID, QUANTITY FROM CART WHERE USER_ID = ? AND BOOK_ID = ?";
		try(PreparedStatement selectSmt = connection.prepareStatement(query))
		{
			selectSmt.setInt(1, userID);
			selectSmt.setInt(2, bookID);
			ResultSet resultSet = selectSmt.executeQuery();
			if(resultSet.next())
			{
				int quantity = resultSet.getInt("QUANTITY") + 1;
				updateQuantity(userID, bookID, quantity);
			}
			else
			{
				addNewProductToCart(userID, bookID);
			}
			return true;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	private static void addNewProductToCart(int userID, int bookID) {
		
		Connection connection = DBConnection.getConnection();
		String insert = "INSERT INTO CART(USER_ID, BOOK_ID, QUANTITY) VALUES(?, ?, ?)";
		try(PreparedStatement insertSmt = connection.prepareStatement(insert))
		{
			insertSmt.setInt(1, userID);
			insertSmt.setInt(2, bookID);
			insertSmt.setInt(3, 1);
			
			int value = insertSmt.executeUpdate();
			if(value > 0)
			{
				System.out.println("Inserted");
			}
			else
			{
				System.out.println("Insert while error");
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	private static void updateQuantity(int userID, int bookID, int quantity) {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getConnection();
		String update = "UPDATE CART SET QUANTITY = ? WHERE USER_ID = ? AND BOOK_ID = ?";
		
		try(PreparedStatement updateSmt = connection.prepareStatement(update))
		{
			updateSmt.setInt(1, quantity);
			updateSmt.setInt(2, userID);
			updateSmt.setInt(3, bookID);
			
			int value = updateSmt.executeUpdate();
			if(value > 0) 
			{
				System.out.println("Increased");
			}
			else 
			{
				System.out.println("Updating while error.");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
