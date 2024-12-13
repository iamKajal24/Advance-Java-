<%@page import="java.io.Writer"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>

	<h1>Hello World</h1>

	<!-- Declaration tag -> for using method or variable -->
	<%!int a = 50;
	int b = 30;
	String name = "Techsolf India";

	public int sum() {
		return a + b;
	}

	public String reverse() {
		StringBuffer br = new StringBuffer(name);
		return br.reverse().toString();
	}%>

	<!-- Scriptlet tag (Scipting element) -->
	<%
	//java source code ko print
	out.println(a);
	out.println("<br>");
	out.println(b);
	out.println("<br>");
	out.println("sum is : " + sum());
	out.println("<br>");
	out.println("name : " + name);
	%>

	<!-- Expression tag (expressive tag) -->
	<!-- Expression tag for print -->
	<h1>
		Sum is :
		<%=sum()%></h1>
	<h1>
		Name :
		<%=name%></h1>

	<h5 style="color: blue">
		Current Date :
		<%=new Date().toString()%></h5>


</body>
</html>
