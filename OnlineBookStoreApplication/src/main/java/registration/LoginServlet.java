package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import dbconnection.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
	

public class LoginServlet extends HttpServlet {
	
	public static boolean isAdmin = false;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hi");
		Connection connection = DBConnection.getConnection();
		
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		System.out.println(userID);
		
		String query = "SELECT ID, NAME, USER_ID, PASSWORD FROM USERS WHERE USER_ID = ? AND PASSWORD = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query))
		{
			preparedStatement.setString(1, userID);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				int id = resultSet.getInt("ID");
				if(userID.indexOf("USER-KK-") == 0)
				{
					isAdmin = false;
					HttpSession session = request.getSession();
					System.out.println("Enter ");
					session.setAttribute("auth", UserDao.getUserDetails(id, password));
					RequestDispatcher dispatcher = request.getRequestDispatcher("view/login/Index.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					isAdmin = true;
					HttpSession session = request.getSession();
					session.setAttribute("auth", UserDao.getUserDetails(id, password));
					RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/AdminDashBoard.jsp");
					dispatcher.forward(request, response);
				}
			}
			else
			{
				PrintWriter out = response.getWriter();
				out.write("Failed While Login");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
}
