<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Example</title>
</head>
<body>

    <h1>This is a JSTL Example</h1>

    <!-- Set tag: Create a variable -->
    <c:set var="i" value="24" scope="application" />

    <!-- c:out: Print expressions -->
    <h1>
        Value of i: <c:out value="${i}" />
    </h1>

    <!-- c:out: Print with a default value -->
    <h1>
        Value of i with default (if null): 
        <c:out value="${i}" default="This is the default value" />
    </h1>
    <hr>

    <!-- c:if: Test condition -->
    <c:if test="${i > 23}">
        <h1>Yes, i is greater than 23 and the condition is true.</h1>
    </c:if>

    <!-- c:if: Test for equality -->
    <c:if test="${i == 23}">
        <h1>Yes, i is equal to 23 and the condition is true.</h1>
    </c:if>

    <!-- c:choose: Java Switch equivalent -->
    <c:choose>
        <c:when test="${i > 0}">
            <h1>This is my case first</h1>
            <h2>Number is positive</h2>
        </c:when>
        <c:when test="${i < 0}">
            <h1>This is my second case</h1>
            <h2>Number is Negative</h2>
        </c:when>
        <c:otherwise>
            <h1>Default case...otherwise</h1>
            <h2>The number is zero.</h2>
        </c:otherwise>
    </c:choose>
    <hr>

    <h1>Find even or odd numbers</h1>
    <c:choose>
        <c:when test="${i % 2 == 0}">
            <h1>This is my first condition...</h1>
            <h2>Even number...</h2>
        </c:when>
        <c:when test="${i % 2 != 0}">
            <h1>This is my second condition...</h1>
            <h2>Odd number...</h2>
        </c:when>
        <c:otherwise>
            <h1>Other conditions...</h1>
        </c:otherwise>
    </c:choose>
    <hr>

    <!-- c:forEach: Looping and traversing -->
    <h1>For each tag: Traversing</h1>
    <c:forEach var="j" begin="1" end="10">
        <h4>
            Value of j is: <c:out value="${j}" />
        </h4>
    </c:forEach>
    <hr>

    

</body>
</html>
