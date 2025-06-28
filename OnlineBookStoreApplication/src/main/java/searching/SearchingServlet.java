package searching;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbconnection.DBConnection;


public class SearchingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		Connection connection = DBConnection.getConnection();
		
		String pattern = "%" + value +"%";
		String query = "SELECT * FROM BOOKS WHERE BOOK_NAME LIKE ? OR AUTHOR_NAME LIKE ?";
		List<Product> list = new ArrayList<>();
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setString(1, pattern);
			preparedStatement.setString(2, pattern);
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
				list.add(row);
			}
			HttpSession session = request.getSession();
			session.setAttribute("productRem", list);
			request.setAttribute("searchValue", "true");
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/login/Index.jsp");
			dispatcher.forward(request, response);
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
	}

}
