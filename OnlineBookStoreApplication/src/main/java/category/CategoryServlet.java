package category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

import java.io.IOException;
import java.util.List;

import dao.ProductDao;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		
		if(category == null)
		{
			return;
		}
		
		ProductDao p = new ProductDao();
		List<Product> books = p.getCategoryViceProducts(category);
		HttpSession session = request.getSession();
		session.setAttribute("productRem", books);
		request.setAttribute("searchValue", "true");
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/login/Index.jsp");
		dispatcher.forward(request, response);
	}

}
