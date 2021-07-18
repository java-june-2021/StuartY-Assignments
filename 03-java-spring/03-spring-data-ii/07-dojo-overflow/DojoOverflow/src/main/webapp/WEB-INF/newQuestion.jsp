<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<title>New Question</title>
</head>
<body>
	<div id="newQuestion">
	<h1>What is your question?</h1>
	<form action="/questions/new" method="post" id="questionForm">
		<p>	
			<label for="question">Question:</label>
			<textarea name="question" rows="10" cols="60" maxlength="1000"><c:out value="${qString}"/></textarea>
			<span class="errormsg"><c:out value="${qError}"/></span>
		</p>
		<p>
			<label for="tags">Tags:</label>
			<input name="tags" type="text" maxlength="120" value="${tString}">
			<span class="errormsg"><c:out value="${tagError}"/></span>
		</p>
		<button>Submit</button>
	</form>
	</div>

</body>
</html>