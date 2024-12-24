package com.tech.blog.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.connectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/RegisterServlet") @MultipartConfig
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain"); // Use plain text for AJAX response
		PrintWriter writer = response.getWriter();

		// fetch all form data
		String check = request.getParameter("agree_terms");
		if (check == null) {
			writer.println("please checked terms and conditions");
		} else {
			String name = request.getParameter("user_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String about = request.getParameter("about");

			// create user object and set all data to that object

			User user = new User(name, email, password, gender, about);

			// create a user dao object

			UserDao dao = new UserDao(connectionProvider.getConnection());
			if (dao.saveUser(user)) {
				// save
				writer.println("done");
			} else {
				writer.println("error");
			}
		}

		writer.close();
	}
}
