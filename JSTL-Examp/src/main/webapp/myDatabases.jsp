<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Databases</title>
</head>
<body>
	<h1>Hi, Showing All Users:</h1>

	<!-- Setting the data source -->
	<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/registerdb" user="root"
		password="root" var="dataSource" />

	<!-- Querying the database -->
	<sql:query dataSource="${dataSource}" var="result">
        SELECT * FROM users;
    </sql:query>

	<!-- Displaying the results -->
	<div class="container">
		<table class="table">
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>User Email</th>
				<th>User Password</th>
			</tr>
			<c:forEach items="${result.rows}" var="row">
				<tr>
					<td><c:out value="${row.id}" /></td>
					<td><c:out value="${row.name}" /></td>
					<td><c:out value="${row.email}" /></td>
					<td><c:out value="${row.password}" /></td>
				</tr>
			</c:forEach>
		</table>


	</div>
</body>
</html>
