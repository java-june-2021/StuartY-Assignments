<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
<div id="container">
	<h1>New Category</h1>
	<form:form action="/categories/new" method="POST" modelAttribute="newCategory" class="newRecord">
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<button>Create</button>
	</form:form>
	<a href="/">Home</a>
</div>

</body>
</html>