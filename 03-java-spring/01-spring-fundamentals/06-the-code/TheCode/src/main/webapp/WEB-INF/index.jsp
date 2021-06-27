<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Secret Code</title>
</head>
<body>
	<div id="container">
		<p class="error"><c:out value="${errorString }"/></p>
		<p>What is the code?</p>
		<form method="POST" action="/submit">
			<input type="text" name="secret">
			<button>Try Code</button>
		</form>
	</div>
</body>
</html>