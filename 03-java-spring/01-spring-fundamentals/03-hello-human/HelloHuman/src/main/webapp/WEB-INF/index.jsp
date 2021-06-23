<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
<style>
	h4 {
	text-align: right;
	}
</style>
</head>
<body>
	<h4><a href="/"><c:out value="${link}"/></a></h4>
	<h1>Hello <c:out value="${yourName}"/>!</h1>
	<p>Welcome to SpringBoot!</p>
</body>
</html>