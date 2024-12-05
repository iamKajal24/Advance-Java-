package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.Condition;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	// private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Processing GET request by myServlet");

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>GET request received</h1>");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Form submitted using POST method");
		// Sending data to the browser
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		// data fetch
		String name = req.getParameter("name");
		System.out.println("Name: " + name);

		String email = req.getParameter("email");
		System.out.println("Email: " + email);

		String password = req.getParameter("pswd");
		System.out.println("Password: " + password);

		String gender = req.getParameter("gender");
		System.out.println("Gender: " + gender);

		String course = req.getParameter("course");
		System.out.println("Course : " + course);

		// Fetch the checkbox value (terms and conditions)
		String termsAccepted = req.getParameter("condition"); // "remember" is the checkbox name

		writer.print("<h1>Welcome to Register Servlet</h1>");
		writer.print("""
				<h2>name: %s</h2>
				<h2>email: %s</h2>
				<h2>password: %s</h2>
				<h2>gender: %s</h2>
				<h2>course: %s</h2>
				""".formatted(name, email, password, gender, course));

		// Check if the terms and conditions are accepted
		if ("on".equals(termsAccepted)) {
			writer.print("<h2>You have accepted the terms and conditions.</h2>");
		} else {
			writer.print("<h2>You have not accepted the terms and conditions.</h2>");
		}
		writer.close();
	}
}
