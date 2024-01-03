<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get image</title>
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
    <form action="getimagebyurl" method="post">
        <label for="imageUrl">ImageUrl:</label>
        <input type="text" name="imageUrl" id="imageUrl" required/>
        <br/>

        <input type="submit" value="Find image" />
    </form>
</div>
</body>
</html>
