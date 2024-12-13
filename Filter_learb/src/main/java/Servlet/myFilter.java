package Servlet;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class myFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic if needed
		System.out.println("Filter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Before Filter");

		// Pass the request and response to the next filter or servlet
		chain.doFilter(request, response);

		System.out.println("After Filter");

		// Authentication
//		HttpServletRequest request2 = (HttpServletRequest) request;
//		HttpSession session = request2.getSession();
//		User user = (User) session.getAttribute("user");
//
//		if (user != null && "Teacher".equals(user.getType())) { // Safe string comparison
//		    // User is logged in and is a Teacher
//		    chain.doFilter(request, response);
//		} else {
//		    System.out.println("Not logged in. Please log in to view this page...");
//		    response.setContentType("text/html"); // Correct MIME type
//		    response.getWriter().println("<h1>Not logged in. Please log in to view this page.</h1>");
//		}

	}

	@Override
	public void destroy() {
		// Cleanup logic if needed
		System.out.println("Filter destroyed");
	}
}
