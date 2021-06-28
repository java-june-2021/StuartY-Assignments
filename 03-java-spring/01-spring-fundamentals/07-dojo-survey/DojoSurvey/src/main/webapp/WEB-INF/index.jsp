<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
<div id="wrapper">
<form action="/submit" method="POST">
	<div class="row">
		<label for="name">Name: </label><input type="text" name="name" id="name">
	</div>
	
	<div class="row">
		<label for="location">Location: </label>
		<select name="location" id="location">
			<option value="San Jose">San Jose</option>
			<option value="Seattle">Seattle</option>
			<option value="Chicago">Chicago</option>
			<option value="Online">Online</option>
		</select>
	</div>
	<div class="row">
		<label for="language">Favorite Language:</label>
		<select name="language" id="language">
			<option value="Python">Python</option>
			<option value="Java">Java</option>
			<option value="JavaScript">JavaScript</option>
			<option value="C#">C#</option>
			<option value="MERN">MERN</option>
		</select>
	</div>
	
	<label for="comments">Comments (optional):</label><textarea id="comments" name="comments"></textarea>
	<button>Submit</button>
</form>
</div>

</body>
</html>