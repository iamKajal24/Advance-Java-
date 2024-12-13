package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("processing do get request by third servlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String nameString= req.getParameter("name");
		System.out.println("Form submitted using post method");
		System.out.println("name :"+nameString);
		
		//sending data to browser
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		
		writer.print("<h1>form submitted</h1>");
		writer.print("""
		    <h2>name: %s</h2>
		    """.formatted(nameString));

	}
}
