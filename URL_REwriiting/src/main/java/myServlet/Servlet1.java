package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>This Servlet only supports POST requests for form submission.</h1>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Form submitted using POST method");
        // Sending data to the browser
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        // Fetching data from the request
        String name = req.getParameter("user_name");
        System.out.println("Name: " + name);

        // Responding to the client
        writer.print("<h1>Welcome to Register Servlet</h1>");
        writer.print("<h2>Your name is: " + name + "</h2>");
        writer.print("<a href='Servlet2?user="+name+"'>Go to Second Servlet</a>");
        writer.close();
    }
}
