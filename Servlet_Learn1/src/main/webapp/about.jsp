<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to servlet tutorial</title>
<link rel="stylesheet" href="<%= application.getContextPath() %>/CSS/style.css">

</head>
<body>
<div class="container">
<%@include file="menu.jsp"%>
<h1>About substring Technologies</h1>
<p>This is very informational tutorial</p>
</div>

<!-- Script Link -->
<script src="<%= application.getContextPath()%>/JS/script.js"></script>
</body>
</html>