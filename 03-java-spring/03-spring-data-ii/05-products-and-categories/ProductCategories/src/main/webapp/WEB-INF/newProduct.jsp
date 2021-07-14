<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<div id="container">
	<h1>New Product</h1>
	<form:form action="/products/new" method="POST" modelAttribute="newProduct" class="newRecord">
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</p>
		<p>
			<form:label path="price">Price:</form:label>
			<form:errors path="price"/>
			<form:input path="price"/>
		</p>
		<button>Create</button>
	</form:form>
	<a href="/">Home</a>
</div>

</body>
</html>