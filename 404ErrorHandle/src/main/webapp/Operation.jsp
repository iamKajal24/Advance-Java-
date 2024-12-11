<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Division Result</title>
</head>
<body>

	<%
	// Fetching input values from the form
	String n1 = request.getParameter("n1");
	String n2 = request.getParameter("n2");

	//conversting String to integer
	int a = Integer.parseInt(n1);
	int b = Integer.parseInt(n2);
	int c = a / b;
	%>
	<h3>
		Result is :
		<%=c%></h3>

</body>
</html>
