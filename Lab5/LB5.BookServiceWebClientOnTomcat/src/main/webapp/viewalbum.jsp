<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Album Details</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<c:choose>
    <c:when test="${not empty errorMsg}">
        <h2>${errorMsg}</h2>
    </c:when>
    <c:otherwise>
        <ul>
            <li>Header: ${album.header}</li>
            <li>Text: ${album.text}</li>
            <li>Date: ${album.date}</li>
            <li>Author First Name: ${album.createdBy.username}</li>
            <li>Access Level: ${album.accessLevel}</li>
        </ul>
        <h3>Images:</h3>
        <ul>
            <c:forEach var="image" items="${album.image}">
                <li>${image.imageUrl}</li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>

<!-- Due PRG pattern, remove error message and album from session after displaying -->
<% session.removeAttribute("errorMsg"); %>
<% session.removeAttribute("album"); %>
</body>
</html>
