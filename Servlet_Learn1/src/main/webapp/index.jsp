<%@page import="org.apache.catalina.core.ApplicationServletRegistration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to servlet tutorial</title>

<!-- including external css -->
<!-- Manual link-> href= "/Servlet_ttu/CSS/style.css" -->
<!-- Dynamic link -->
<link rel="stylesheet" href="<%= application.getContextPath() %>/CSS/style.css">

</head>
<body>
<div class="container">
<!-- Page directive -->
<%@include file="menu.jsp"%>
<h1>welcome to servlet Crash Course</h1>
<p>This is very informational tutorial</p>

<form action="${pageContext.request.contextPath}/third" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <input type="submit" value="Submit">
    <input type="Reset" value="Edit">
</form>



</div>

<!-- Script Link -->
<script src="<%= application.getContextPath()%>/JS/script.js"></script>
</body>
</html>