<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Album</title>
	<link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
	<form action="add" method="post">
		<label for="header">Header:</label>
		<input type="text" name="header" id="header" required/>
		<br/>

		<label for="text">Text:</label>
		<textarea name="text" id="text" required></textarea>
		<br/>

		<label for="date">Date:</label>
		<input type="text" name="date" id="date" required/>
		<br/>

		<h3>Access Level</h3>
		<select name="accessLevel" id="accessLevel">
			<option value="PRIVATE">Private</option>
			<option value="LINK_ONLY">Link Only</option>
			<option value="PUBLIC">Public</option>
		</select>
		<br/>

		<h3>Author</h3>
		<label for="username">Username:</label>
		<input type="text" id="username" name="username" required/>
		<br/>


		<h3>Images</h3>
		<label for="countImages">Count images:</label>
		<input type="number" id="countImages" name="countImages" required/>
		<div id="albumImages">
			<!-- JavaScript can be used to dynamically add input fields for album images based on the count -->
		</div>

		<input type="submit" value="Add" />
	</form>

	<script>
		document.addEventListener("DOMContentLoaded", function () {
			const countImagesInput = document.getElementById("countImages");
			const albumImagesContainer = document.getElementById("albumImages");

			countImagesInput.addEventListener("input", function () {
				const count = parseInt(countImagesInput.value);
				albumImagesContainer.innerHTML = ""; // Clear previous input fields

				for (let i = 1; i <= count; i++) {
					const imageUrlLabel = document.createElement("label");
					imageUrlLabel.textContent = "Image URL " + i;
					albumImagesContainer.appendChild(imageUrlLabel);

					const imageUrlInput = document.createElement("input");
					imageUrlInput.name = "imageUrl" + i;
					albumImagesContainer.appendChild(imageUrlInput);
					albumImagesContainer.appendChild(document.createElement("br"));
				}
			});
		});
	</script>
</div>
</body>
</html>
