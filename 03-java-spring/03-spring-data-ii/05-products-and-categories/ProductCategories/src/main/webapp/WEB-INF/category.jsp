<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
<div id="container">
	<h1><c:out value="${categoryname }"/></h1>
	<div class="relatedlist">
	<h3>Products</h3>
	<ul>
	<c:forEach items="${products}" var="product">
		<li><c:out value="${product.name}"/></li>
	</c:forEach>
	</ul>
	</div>
	<div class="selectForm">
	<form action="/categories/${id}" method="POST">
		<label for="product">Add Product</label>
		<select name="product">
			<c:forEach items="${notProducts}" var="notProd">
				<option value="${notProd.id}">${notProd.name }</option>
			</c:forEach>
		</select>
		<button>Update</button>
	
	</form>
	
	<form action="/categories/${id}/delete" method="POST">
		<label for="removeProd">Remove Product</label>
		<select name="removeProd">
			<c:forEach items="${products}" var="product">
				<option value="${product.id }">${product.name }</option>
			</c:forEach>
		</select>
		<button>Remove From Category</button>
	</form>
	</div>
	<p>
	<a href="/">Home</a>
	</p>
</div>

</body>
</html>