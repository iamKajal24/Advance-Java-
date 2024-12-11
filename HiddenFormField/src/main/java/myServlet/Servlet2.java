package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>This Servlet only supports POST requests for form submission.</h1>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the name from request parameters (either from form submission or forwarded request)
        String name = req.getParameter("user_name");

        // Send the response
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        if (name != null && !name.trim().isEmpty()) {
            writer.print("<h1 style='color:blue;'>Welcome to Servlet 2</h1>");
            writer.print("<h2 style='color:red;'>Welcome back, " + name + "!</h2>");
        } else {
            writer.print("<h2 style='color:red;'>No name provided!</h2>");
        }

        writer.close();
    }
}
