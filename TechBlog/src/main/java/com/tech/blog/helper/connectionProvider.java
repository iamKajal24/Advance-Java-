package com.tech.blog.helper;

import java.sql.*;

public class connectionProvider {
	private static Connection con;

	public static Connection getConnection() {

		try {
			if (con == null) {
				// driver class loader
				Class.forName("com.mysql.cj.jdbc.Driver");

				// create a connection
				String url = "jdbc:mysql://localhost:3306/techblog";
				String username = "root";
				String dbPassword = "root";

				con = DriverManager.getConnection(url, username, dbPassword);
			}

		} catch (Exception e) {

		}

		return con;
	}
}
