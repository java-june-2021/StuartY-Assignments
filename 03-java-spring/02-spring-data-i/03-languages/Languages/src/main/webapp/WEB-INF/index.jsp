<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
<div class ="container">
<table>
	<thead><th>Name</th><th>Creator</th><th>Version</th><th>Action</th></thead>
	<tbody>
		<c:forEach items="${languages}" var="language" varStatus="loop">
		<tr>
			<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
			<td><c:out value="${language.creator}"/></td>
			<td><c:out value="${language.version}"/></td>
			<td>
			<a href="/languages/${language.id}/delete">Delete</a> 
			<a href="/languages/${language.id}/edit">Edit</a>
			</td>
		</tr>
		</c:forEach>
	
	</tbody>
</table>

<form:form action="/languages" method="post" modelAttribute="newLanguage">
	<p>
		<form:label path="name">Name</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>		
	</p>
	
		<p>
		<form:label path="creator">Creator</form:label>
		<form:errors path="creator"/>
		<form:input path="creator"/>		
	</p>
	
		<p>
		<form:label path="version">Version</form:label>
		<form:errors path="version"/>
		<form:input path="version"/>		
	</p>	
	
	<input type="submit" value="submit"/>
</form:form>
</div>
</body>
</html>