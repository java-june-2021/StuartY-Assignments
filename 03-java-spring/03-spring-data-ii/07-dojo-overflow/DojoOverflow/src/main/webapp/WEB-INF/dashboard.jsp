<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<title>Questions Dashboard</title>
</head>
<body>
<div id="dashboard">
	<h1>Questions Dashboard</h1>
	<table>
		<thead>
			<tr><th class="questionHeader">Question</th><th class="tagHeader">Tags</th></tr>
		</thead>
		<tbody>
			<c:forEach items="${questions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}">${question.question}</a></td>
					<td>
						<c:forEach items="${question.tags}" var="tag">
							<c:out value="${tag.subject}"/> 
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/questions/new">New Question</a>
	</div>
</body>
</html>