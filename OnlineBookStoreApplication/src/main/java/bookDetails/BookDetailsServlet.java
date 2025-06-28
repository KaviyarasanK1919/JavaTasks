package bookDetails;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.CartDao;
import dao.UserDao;

public class BookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String book = request.getParameter("bookId");
		int bookID = -1;
		if(book == null)
		{
			return;
		}
		bookID = Integer.parseInt(book);
		HttpSession session = request.getSession();
		System.out.println("JIKI");
		session.setAttribute("bookDetails", ""+bookID);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/book/BookDetails.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
