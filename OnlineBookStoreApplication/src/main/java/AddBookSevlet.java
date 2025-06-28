

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
 * Servlet implementation class AddBookSevlet
 */
public class AddBookSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("bookName");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		String priceTemp = request.getParameter("price");
		int price = Integer.valueOf(priceTemp);
		String image = "image/" + request.getParameter("image");
		
		String query = "INSERT INTO BOOKS(BOOK_NAME, AUTHOR_NAME, CATEGORY, PRICE, IMAGE_LINK) VALUES(?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setString(3, category);
			preparedStatement.setInt(4, price);
			preparedStatement.setString(5, image);
			
			int value = preparedStatement.executeUpdate();
			if(value > 0)
			{
				request.setAttribute("message", "Sucessfully Added.");
				request.getRequestDispatcher("view/admin/AdminDashBoard.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message", "Book added failed.");
				request.getRequestDispatcher("view/admin/AdminDashBoard.jsp").forward(request, response);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
