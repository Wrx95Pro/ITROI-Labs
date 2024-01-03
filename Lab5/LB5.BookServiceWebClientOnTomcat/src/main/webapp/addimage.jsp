<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Image</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
    <form action="addimage" method="post">
        <label for="albumId">Album ID:</label>
        <input type="number" name="albumId" id="albumId" required/>
        <br/>

        <label for="imageUrl">Image URL:</label>
        <input type="text" name="imageUrl" id="imageUrl" required/>
        <br/>

        <input type="submit" value="Add Image" />
    </form>
</div>
</body>
</html>
