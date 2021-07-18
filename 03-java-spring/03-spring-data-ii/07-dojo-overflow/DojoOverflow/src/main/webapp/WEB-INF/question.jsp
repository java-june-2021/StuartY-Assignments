<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/stylesheet.css">
<title>Question Profile</title>
</head>
<body>
	<div id="questionpage">
		<h1><c:out value="${theQuestion.question}"/></h1>
		<div id="tagbar">
			<h2>Tags:</h2>
			<c:forEach items="${theQuestion.tags}" var="tag">
				<div class="tagbox">
					<c:out value="${tag.subject}"/>
				</div>
			</c:forEach>
			
		</div>
		<div id="answersbody">
		<table>
			<thead>
				<tr><th>Answers</th></tr>
			</thead>
			<tbody>
				<c:forEach items="${theQuestion.answers}" var="answer">
					<tr><td><c:out value="${answer.answer}"/></td></tr>				
				</c:forEach>
			</tbody>
		</table>
		<div id="answerform">
			<h2>Add your answer:</h2>
			<form:form action="/questions/${id}" method="post" modelAttribute="newAnswer">
			<p>
				<form:label path="answer">Answer: </form:label>
				<span class="errormsg"><form:errors path="answer"/></span>
				<form:textarea path="answer"/>
			</p>
			<input type="submit" value="Answer it!"/>
			</form:form>
		</div>
		</div>
	</div>

</body>
</html>