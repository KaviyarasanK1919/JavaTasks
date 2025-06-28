package cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import dbconnection.DBConnection;

/**
 * Servlet implementation class IncrementServlet
 */
public class IncrementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("userID");
		String book = request.getParameter("bookID");
		int userID = 0;
		int bookID = 0;
		if(user != null && book != null)
		{
			System.out.println("iNCRE Inside");
			System.out.println(user);
			System.out.println(book);
			userID = Integer.valueOf(user);
			bookID = Integer.valueOf(book);
		}
		System.out.println(userID);
		System.out.println(bookID);
		String query = "UPDATE CART SET QUANTITY = QUANTITY + 1 WHERE USER_ID = ? AND BOOK_ID = ? AND QUANTITY < 100";
		Connection connection = DBConnection.getConnection();
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			if (connection == null || connection.isClosed()) {
			    System.out.println("Database connection is not available.");
			    return;
			}
			 preparedStatement.setInt(1, userID);
			 preparedStatement.setInt(2, bookID);
			 int val = preparedStatement.executeUpdate();
			 if(val > 0) 
			 {
				System.out.println("update Success");
				RequestDispatcher dispatcher = request.getRequestDispatcher("view/cart/CartJsp.jsp");
				dispatcher.forward(request, response);
			 }
			 else System.out.println("Failed");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
