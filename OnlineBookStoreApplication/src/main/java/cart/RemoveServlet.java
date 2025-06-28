package cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.CartDao;

/**
 * Servlet implementation class RemoveServlet
 */
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("userID");
		String book = request.getParameter("bookID");
		int userID = 0;
		int bookID = 0;
		if(user != null && book != null)
		{
			userID = Integer.valueOf(user);
			bookID = Integer.valueOf(book);
		}
		System.out.println(userID);
		System.out.println(bookID);
		CartDao obj = new CartDao();
		int cartID = obj.getCartID(userID, bookID);
		obj.removeBookInCart(cartID);
		System.out.println("Deleted.");
		 RequestDispatcher dispatcher = request.getRequestDispatcher("view/cart/CartJsp.jsp");
		 dispatcher.forward(request, response);
	}

}
