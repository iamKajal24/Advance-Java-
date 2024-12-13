<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sorry some thing Went Wrong</title>
<style>
* {
	padding: 0px;
	margin: 0px;
}
</style>

</head>
<body>
	<div style="padding: 20px; color: blue; background: #e2e2e2;">
		<h1>Sorry !! Something Went Wrong..</h1>
		
		<p><%= exception %></p>

	</div>

</body>
</html>