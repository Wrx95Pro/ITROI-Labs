<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Albums</title>
	<link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<c:choose>
	<c:when test="${empty albums}">
		<h2>No albums found</h2>
	</c:when>
	<c:otherwise>
		<table class="brd">
			<thead class="tabhead">
			<colgroup class="left"/>
			<colgroup class="left"/>
			<colgroup class="left"/>
			<colgroup class="right"/>
			<colgroup class="right"/>
			<tr>
				<th class="brd">Album id</th>
				<th class="brd">Header</th>
				<th class="brd">Text</th>
				<th class="brd">Date</th>
				<th class="brd">AuthorUserName</th>
				<th class="brd">Access Level</th>
				<th class="brd">Images</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="album" items="${albums}">
				<tr>
					<td class="brd">${album.id}</td>
					<td class="brd">${album.header}</td>
					<td class="brd">${album.text}</td>
					<td class="brd">${album.date}</td>
					<td class="brd">${album.createdBy.username}</td>
					<td class="brd">${album.accessLevel}</td>
					<td class="brd">
						<select name="images" multiple="multiple" size="5">
							<c:forEach var="image" items="${album.image}">
								<option>${image.imageUrl}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>
