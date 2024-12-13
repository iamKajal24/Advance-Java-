<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/mylib.tld" prefix="t"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custome Tags</title>
</head>
<body>

	<h1>Greet Message</h1>
	<hr>
	<t:mytag></t:mytag>
	<t:printTable number="2" color="red"></t:printTable>
	<!-- <t:printTable number="2" color="blue"></t:printTable>
	 -->

</body>
</html>