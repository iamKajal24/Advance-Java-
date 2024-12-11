package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Handle GET requests
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
      //  writer.print("<h1>This Servlet only supports POST requests for form submission.</h1>");
        writer.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Form submitted using POST method");

		// Sending data to the browser
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("<h1 style='color:blue;'>Welcome to Servlet 2</h1>");
		// Fetching the name parameter from the request
		String name = req.getParameter("user_name");

		// Check if the name parameter is present

		writer.print("<h2 style='color:red;'>Welcome back, " + name + "</h2>");

		writer.close();
	}

}
