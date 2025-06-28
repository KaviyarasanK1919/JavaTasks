

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

import com.google.gson.Gson;

/**
 * Servlet implementation class BookServletSample
 */
public class BookServletSample extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> books = new ArrayList<>();
    public void init()
    {
    	books.add("DEmon");
    	books.add("Tanjiro");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(books);
        out.println(json);
        
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newBook = req.getParameter("name");
        if (newBook != null && !newBook.trim().isEmpty()) {
            books.add(newBook);
            resp.getWriter().println("Book added: " + newBook);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Invalid book name");
        }
	}

}
