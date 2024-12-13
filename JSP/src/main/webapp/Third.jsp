<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Taglib Directive Tutorial</title>
</head>
<body>

<h1>Taglib Directive Tutorial:</h1>
<h1>Error Handle </h1>
<hr>

<%! 
    int n1 = 20; 
    int n2 = 0; 
%>

<%
    int division = n1 / n2; 
%>

<h1>Division = <%= division %></h1>

</body>
</html>
