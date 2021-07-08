<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
</head>
<body>
	<div id="container">
		<a href="/dashboard">Dashboard</a>
		
		<table>
			<tr><td>Title</td><td><c:out value="${song.title}"/><tr>
			<tr><td>Artist</td><td><c:out value="${song.artist}"/><tr>
			<tr><td>Rating</td><td><c:out value="${song.rating}"/><tr>
		</table>
		<a href="/delete/${song.id}">Delete</a>
	</div>

</body>
</html>