<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bushido Code</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<ul>
	<c:forEach items="${values}" var="value">
		<li><c:out value="${value}"/></li>
	</c:forEach>
</ul>
</body>
</html>