<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Employees</h2>	
	<table>
		<tr>
			<td>NAME</td><td>Info </td><td>Salary</td><td>SSN</td><td></td>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
			<td>${book.name}</td>
			<td>${book.info}</td>
			<td>${book.author}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/logout' />">Add New Employee</a>
</body>
</html>