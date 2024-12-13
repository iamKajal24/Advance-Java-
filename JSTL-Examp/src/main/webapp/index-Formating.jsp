<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index - Formatting</title>
</head>
<body>
    <h1>This is a formatting page...</h1>

    <!-- Set Number Using Scriptlet -->
    <%
        double num = 1234.55;
        String name = "John Doe";
        java.util.Date currentDate = new java.util.Date();
    %>

    <!-- Display Name Using JSTL -->
    <h1><c:out value="<%= name %>" /></h1>

    <!-- Format Number Using JSTL -->
    <h1>Formatted Number: <fmt:formatNumber value="<%= num %>" pattern="#,###.00" /></h1>

    <!-- Format Date Using JSTL -->
    <h2>Formatted Date: <fmt:formatDate value="<%= currentDate %>" pattern="yyyy-MM-dd" /></h2>

</body>
</html>
