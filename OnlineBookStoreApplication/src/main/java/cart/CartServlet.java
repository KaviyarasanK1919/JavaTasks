package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CartDao;
import dbconnection.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("bookId");
		String id = request.getParameter("userID");
		int userID = -1;
		int bookID = -1;
		if(book == null || id == null)
		{
		   return;
		}
		bookID = Integer.valueOf(book);
		userID = Integer.valueOf(id);
		
		
		boolean value = CartDao.addBookToCart(userID, bookID);
		
		if(value)
		{
			HttpSession session = request.getSession();
			session.setAttribute("cart", "Product sucessfully Added to Cart.");
			//request.setAttribute("cart", "Product sucessfully Added to Cart.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/login/Index.jsp");
		dispatcher.forward(request, response);
	}
}