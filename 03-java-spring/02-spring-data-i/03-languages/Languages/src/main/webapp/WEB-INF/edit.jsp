<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<meta charset="ISO-8859-1">
<title>${languageView.name}</title>
</head>
<body>
<div class ="container">
	<p><a href="/languages/${languageView.id}/delete">Delete</a> <a href="/languages">Dashboard</a></p>
	
	<form:form action="/languages/${languageView.id }/edit" method="post" modelAttribute="languageView">
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