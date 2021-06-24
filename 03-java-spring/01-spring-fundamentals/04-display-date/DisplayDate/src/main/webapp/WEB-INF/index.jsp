<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time Dashboard</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
	<div>
		<a href="/date">Date Template</a> <a href="/time">Time Template</a>
	</div>
	<c:out value="${data}"/>
</body>
</html>