<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
<div id="container">
	<h1><c:out value="${productname }"/></h1>
	<div class="relatedlist">
	<h3>Categories</h3>
	<ul>
	<c:forEach items="${productCategories}" var="productcategory">
		<li><c:out value="${productcategory.name}"/></li>
	</c:forEach>
	</ul>
	</div>
	
	<form action="/products/${id}" method="POST" class="selectForm">
		<label for="category">Add Category</label>
		<select name="category">
			<c:forEach items="${notCategories }" var="notCat">
				<option value="${notCat.id}">${notCat.name }</option>
			</c:forEach>
		</select>
		<button>Update</button>
	
	</form>
	
	<form action="/products/${id}/delete" method="POST" class="selectForm">
		<label for="removeCat">Remove Category</label>
		<select name="removeCat">
			<c:forEach items="${productCategories}" var="productcategory">
				<option value="${productcategory.id }">${productcategory.name }</option>
			</c:forEach>
		</select>
		<button>Remove From Categories</button>
	</form>
	
<%-- 	<form:form action="/products/${id}" method="POST" modelAttribute="product" class="selectform">
		<p>
			<form:label path="categories">Add Category:</form:label>
			<form:errors path="categories"/>
			<form:select path="categories">
				<c:forEach items="${notCategories }" var="notCat">
					<option value="${notCat.id}">${notCat.name }</option>
				</c:forEach>
			</form:select>
		</p>
		<button>Update</button>
	</form:form> --%>
	<a href="/">Home</a>
</div>

</body>
</html>