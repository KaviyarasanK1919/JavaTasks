package logout;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
        // Redirect to login page or home page
        System.out.println("logged outs.");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    	response.setHeader("Expires", "0");
        request.getSession(false).invalidate();
        response.sendRedirect("view/login/Login.jsp");
        return;
	}

}
