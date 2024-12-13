<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.Random, java.util.ArrayList, java.io.*"%>

<%@ page isErrorPage="true"%>
<!-- Error page directive -->

<%@ page session="false"%>
<!-- Disable session -->

<!-- Include directive -->
<%@ include file="First.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>

	<h1>JSP Directive Tag Learn</h1>

	<h1>Random Number:</h1>
	<%
	Random r = new Random();
	int n = r.nextInt(100); // Generate a random number between 0 and 99
	%>
	<h1><%=n%></h1>

</body>
</html>
