package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.tech.blog.dao.LikedDao;
import com.tech.blog.helper.connectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LikedServlet")
public class LikedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests (if needed)
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("GET request is not supported for this operation.");
        out.close(); // Close the PrintWriter here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type to plain text
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String operation = request.getParameter("Operation");
        int uid = Integer.parseInt(request.getParameter("uid"));
        int pid = Integer.parseInt(request.getParameter("pid"));

        LikedDao ldao = new LikedDao(connectionProvider.getConnection());
        boolean isLiked = false;

        if ("like".equals(operation)) {
            isLiked = ldao.insertLike(pid, uid);
        }

        // Respond with a plain text message
        if (isLiked) {
            out.println("true");
        } else {
            out.println("false");
        }
        out.close();
    }
}
