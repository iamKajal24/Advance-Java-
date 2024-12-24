package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.Helper;
import com.tech.blog.helper.connectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();

        // Retrieve user input
        String email = request.getParameter("user_email");
        String name = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        String about = request.getParameter("user_about");
        Part part = request.getPart("image");
        String imageName = part != null ? part.getSubmittedFileName() : "";

        // Get current user from session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        // Update user details
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setAbout(about);

        // Handle profile image
        String defaultImage = "default.png"; // Default profile image
        String oldImagePath = getServletContext().getRealPath("/") + "image" + File.separator + user.getProfile();

        if (!imageName.isEmpty()) {
            // Delete the old profile picture if a new one is uploaded
            Helper.deleteFile(oldImagePath);

            // Save new profile picture
            String newImagePath = getServletContext().getRealPath("/") + "image" + File.separator + imageName;
            if (Helper.saveFile(part.getInputStream(), newImagePath)) {
                user.setProfile("Image/" + imageName); // Update profile path
            }
        } else if (user.getProfile() == null || user.getProfile().isEmpty()) {
            // Assign default profile picture if none exists
            user.setProfile("Image/" + defaultImage);
        }

        // Update user in database
        UserDao userDao = new UserDao(connectionProvider.getConnection());
        boolean ans = userDao.updateUser(user);

        // Respond to the user
        if (ans) {
            Message msg = new Message("Profile details updated successfully!", "success", "alert-success");
            session.setAttribute("msg", msg);
        } else {
            Message msg = new Message("Something went wrong...", "error", "alert-danger");
            session.setAttribute("msg", msg);
        }
        response.sendRedirect("profile.jsp");
        writer.close();
    }
}
