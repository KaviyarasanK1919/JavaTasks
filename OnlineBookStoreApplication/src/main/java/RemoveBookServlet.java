

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
 * Servlet implementation class RemoveBookServlet
 */
public class RemoveBookServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("bookId");
		int bookId = Integer.valueOf(id);
		Connection connection = DBConnection.getConnection();
		String query = "DELETE FROM BOOKS WHERE ID = ?";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setInt(1, bookId);
			int value = preparedStatement.executeUpdate();
			if(value > 0)
			{
				request.setAttribute("message", "Sucessfully Removed.");
				request.getRequestDispatcher("view/admin/AdminDashBoard.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message", "This Book is not found.");
				request.getRequestDispatcher("view/admin/AdminDashBoard.jsp").forward(request, response);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
