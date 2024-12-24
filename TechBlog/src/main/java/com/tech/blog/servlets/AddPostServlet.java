package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.PostDao;
import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.Post;
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

@WebServlet("/AddPostServlet")
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain"); // Use plain text for AJAX response
		PrintWriter writer = response.getWriter();

		int cid = Integer.parseInt(request.getParameter("cid"));
		String pTitle = request.getParameter("pTitle");
		String pContent = request.getParameter("pContent");
		String pCode = request.getParameter("pCode");
		Part part = request.getPart("Pic");
		//getting current id
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("currentUser");
		//user.getId();
		
		//writer.println("your post title is : " + pTitle);
		//writer.println(part.getSubmittedFileName());
		
		Post p = new Post(pTitle,pContent,pCode,part.getSubmittedFileName(), null,cid,user.getId());
		
		PostDao dao= new PostDao(connectionProvider.getConnection());
		if(dao.savePost(p)) {
			String path = getServletContext().getRealPath("/") + "blog_pics" + File.separator + part.getSubmittedFileName();
			Helper.saveFile(part.getInputStream(), path);
			writer.println("done");
		}
		else {
			writer.println("error");
		}
		
         
         
         writer.close();
	}
}
