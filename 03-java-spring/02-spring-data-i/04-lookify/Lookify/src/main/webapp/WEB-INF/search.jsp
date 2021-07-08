<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
</head>
<body> 
	<div id="container">
		<div id="header">
			<a href="search/topTen">Top Ten</a>
			<form action="/search" method=GET>
				<input type="text" name="search" id="search" value="${search}">
				<button>Search Artists</button>
			</form>
			<a href="/dashboard">Dashboard</a>
		</div>
		<table class="data">
			<thead>
				<tr>
					<th>Name</th><th>Rating</th><th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song" varStatus="loop">
					<tr>
						<td><a href="/songs/${song.id }"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						<td><a href="/delete/${song.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>