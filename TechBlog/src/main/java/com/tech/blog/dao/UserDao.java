package com.tech.blog.dao;

import java.sql.*;

import com.tech.blog.entities.User;

public class UserDao {

	private Connection con;

	public UserDao(Connection con) {

		this.con = con;
	}

	// method to insert user to database;
	public boolean saveUser(User user) {

		boolean f = false;

		try {

			// user-->database
			String query = "insert into user(name, email,password,gender,about) values(?,?,?,?,?)";

			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getGender());
			psmt.setString(5, user.getAbout());

			psmt.execute();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// get user by useremail and user password

	public User getUserByEmailAndPassword(String email, String password) {
		User user = null; // Initialize user object
		String query = "SELECT * FROM user WHERE email = ? AND password = ?";

		try (PreparedStatement psmt = con.prepareStatement(query)) { // Ensure resources are closed
			psmt.setString(1, email);
			psmt.setString(2, password);

			try (ResultSet set = psmt.executeQuery()) {
				if (set.next()) {
					user = new User(); // Create a new User object
					user.setId(set.getInt("id"));
					user.setName(set.getString("name")); // Map 'name' column
					user.setEmail(set.getString("email")); // Map 'email' column
					user.setPassword(set.getString("password")); // Map 'password' column
					user.setGender(set.getString("gender")); // Map 'gender' column
					user.setAbout(set.getString("about")); // Map 'about' column
					user.setDateTime(set.getTimestamp("registerDate")); // Map 'registerDate' column
					user.setProfile(set.getString("profile")); // Map 'registerDate' column
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Replace with proper logging in production
		}
		return user; // Return the user object (or null if not found)
	}

	// Update details
	public boolean updateUser(User user) {
		boolean f =false;
		try {
			String query = "update user set name=?, email=?, password=?, gender=?, about=?, profile=? where id=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getGender());
			psmt.setString(5, user.getAbout());
			psmt.setString(6, user.getProfile());
			psmt.setInt(7, user.getId());

			psmt.executeUpdate();
		     f=true;

		} catch (Exception e) {
               e.printStackTrace();
               System.out.println("Something error...");
		}
		return f;
	}

     public User getUserByUserId(int userId) throws SQLException {
    	 User user=null;
    	 
    	 String query="select * from user where id=?";
    	 PreparedStatement ps=this.con.prepareStatement(query);
    	 ps.setInt(1, userId);
    	 ResultSet set=ps.executeQuery();
    	 if(set.next()) {
    		 user = new User(); // Create a new User object
				user.setId(set.getInt("id"));
				user.setName(set.getString("name")); // Map 'name' column
				user.setEmail(set.getString("email")); // Map 'email' column
				user.setPassword(set.getString("password")); // Map 'password' column
				user.setGender(set.getString("gender")); // Map 'gender' column
				user.setAbout(set.getString("about")); // Map 'about' column
				user.setDateTime(set.getTimestamp("registerDate")); // Map 'registerDate' column
				user.setProfile(set.getString("profile")); // Map 'registerDate' column
    	 }
    	 
    	 return user;
     }

}
