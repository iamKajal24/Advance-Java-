package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//@WebServlet("/Register")
@MultipartConfig
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain"); // Use plain text for AJAX response
		PrintWriter writer = response.getWriter();

		// Retrieve form data
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		// form image
		Part part = request.getPart("image");

		// Save file to server
		String filename = part.getSubmittedFileName();

		// File UploadPath
		InputStream iStream = part.getInputStream();
		byte[] data = new byte[iStream.available()];

		iStream.read(data);
		String path = getServletContext().getRealPath("/") + "img" + File.separator;
		System.out.println(path);

		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);

		fos.close();

		// print
//		System.out.println(filename);

		// JDBC variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// Simulate loader delay
			Thread.sleep(3000);

			// Load JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create a connection
			String url = "jdbc:mysql://localhost:3306/registerdb";
			String username = "root";
			String dbPassword = "root";

			conn = DriverManager.getConnection(url, username, dbPassword);

			// Prepare SQL query
			String query = "INSERT INTO users (name, email, password,imageName) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);

			// Set parameters
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, filename);

			// Execute query
			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				writer.write("success"); // Send plain text response
			} else {
				writer.write("failure");
			}

		} catch (Exception e) {
			writer.write("error"); // Send error response
			e.printStackTrace(); // Log the error
		} finally {
			// Close resources
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		writer.close();
	}
}
