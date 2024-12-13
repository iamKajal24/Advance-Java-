<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test page </title>
</head>
<body>

<h1>This is test page</h1>
<h1><c:out value="${i}"></c:out></h1>

<!-- Creating a URL with parameters -->
    <!-- 
    <c:url var="myurl" value="http://www.google.com/search">
        <c:param name="q" value="learn code with Kajal Servlet"></c:param>
    </c:url>

    <h1>
        Constructed URL: <c:out value="${myurl}" />
    </h1>
    -->

    <!-- Redirecting to the constructed URL -->
    <!-- 
    <c:redirect url="${myurl}" />
    -->

</body>
</html>