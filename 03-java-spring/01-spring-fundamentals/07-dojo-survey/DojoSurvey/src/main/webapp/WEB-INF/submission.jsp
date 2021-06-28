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
		<h2>Submitted Info</h2>
		<div class="row">
			<p>Name:</p><p><c:out value="${yourName}"/><p>
		</div>
		<div class="row">
			<p>Dojo Location:</p><p><c:out value="${location}"/><p>
		</div>
		<div class="row">
			<p>Favorite Language:</p><p><c:out value="${language}"/><p>
		</div>
		<div class="row">
			<p>Comment:</p><p><c:out value="${comment}"/><p>
		</div>
		<a href="/"><button>Go Back</button></a>
	
	</div>

</body>
</html>