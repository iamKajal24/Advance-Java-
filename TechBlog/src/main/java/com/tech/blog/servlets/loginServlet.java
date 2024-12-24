package com.tech.blog.servlets;


import java.io.IOException;
import java.io.PrintWriter;


import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.connectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain"); // Use plain text for AJAX response
		PrintWriter writer = response.getWriter();

		// fetch username or password from request
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			

			// Call the method to retrieve the user
			UserDao dao = new UserDao(connectionProvider.getConnection()); // Ensure UserDao is initialized correctly
			User u = dao.getUserByEmailAndPassword(email, password);
			if(u==null) {
				//login error
//				writer.println("Invalid Details ...try again");
			Message msg = new Message("Invalid Details ! try with another" ,"error","alert-danger");
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
			
			response.sendRedirect("login_page.jsp");
			}
			else {
				//login success
				HttpSession s = request.getSession();
				s.setAttribute("currentUser", u);
				response.sendRedirect("profile.jsp");
			}

		writer.close();
	}


}
