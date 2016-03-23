<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

</head>


<body>
<div class="container">
    <jsp:include page="header.jsp"/>

    <h2>List of Books</h2>
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Info</td>
            <td>Salary</td>
            <td>SSN</td>
            <td></td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.info}</td>
                <td>${book.author}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="well">
        <a href="<c:url value='/logout' />">Add New Employee</a>
    </div>
</div>

</body>
</html>