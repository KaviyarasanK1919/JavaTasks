package bookDetails;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.CartDao;

public class BookDetailsCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("bookId");
		String user = request.getParameter("userID");
		
		if(book == null || user == null)
		{
		   return;
		}
		int bookID = Integer.valueOf(book);
		int userID = Integer.valueOf(user);
		
		boolean value = CartDao.addBookToCart(userID, bookID);
		HttpSession session = request.getSession();
		if(value)
		{
			session.setAttribute("cartAdd", "Product added to the cart.");;
		}
		System.out.println("JIKI");
		session.setAttribute("bookDetails", ""+bookID);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/book/BookDetails.jsp");
		requestDispatcher.forward(request, response);
	}

}
