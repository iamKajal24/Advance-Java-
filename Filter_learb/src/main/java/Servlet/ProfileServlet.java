package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // Redirect GET requests to POST (optional, based on your use case)
	        doPost(req, resp);
	    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//sending data to browser
		System.out.println("Profile servlet excuted...");
			resp.setContentType("text/html");
			PrintWriter writer=resp.getWriter();
			
			writer.print("<h1>Welcome Profile Servlet Page</h1>");
			writer.close();
		
	}
}
