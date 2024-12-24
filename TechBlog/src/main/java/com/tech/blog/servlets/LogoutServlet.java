package com.tech.blog.servlets;

import java.io.IOException;

import com.tech.blog.entities.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the current session
        HttpSession s = request.getSession();
        s.removeAttribute("currentUser");

        // Set logout message in session
        Message m = new Message("Logout Successfully", "success", "alert-success");
        s.setAttribute("msg", m);

        // Redirect to login page
        response.sendRedirect("login_page.jsp");
    }
}
