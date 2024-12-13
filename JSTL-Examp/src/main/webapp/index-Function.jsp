<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fuctions-> String Manipulation && SQL </title>
</head>
<body>
<h1>Fun Page :</h1>
<p>this page is all about using functions tags..</p>
<c:set var="name" value=" TECHSOFT INDIA "></c:set>
<h1><c:out value="${name}"></c:out></h1>
<!-- length => fn:length(name) -->
<h1>Length of name is <c:out value="${fn:length(name)}"></c:out></h1>
<!-- Small letter => fn:toLowerCase(name) -->
<h2>Small of name is : <c:out value="${fn:toLowerCase(name)}"></c:out></h2>
<!-- Upper Case -->
<h3>Upper Case is : <c:out value="${fn:toUpperCase(name)}"></c:out></h3>
<!-- Trim -->
<h3>Trim Functions: <c:out value="${fn:trim(name)}"></c:out></h3>
<!-- Contains -->
<h3>Contains Function: <c:out value="${fn:contains(name, 'substring')}"></c:out></h3>
<!-- Replace -->
<h3>Replace Function: <c:out value="${fn:replace('TECHKAJALSOFT INDIA', 'KAJAL', '')}"></c:out></h3>
<!-- subString -->
<h3>SubString Function: <c:out value="${fn:substring('hello world', 0, 5)}"></c:out></h3>
<!-- Join -->
<h3>Join Function: <c:out value="${fn:join(myList, ',')}"></c:out></h3>
<!-- split -->
<h3>Split Function: <c:out value="${fn:split('a,b,c', ',')}" /></h3>
<!-- containsIgnoreCase -->

</body>
</html>