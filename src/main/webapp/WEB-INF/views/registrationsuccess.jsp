<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="well">
        <div class="success">
            Confirmation message : ${success}
            <br>
            Would you like to <a href="<c:url value='/registration' />">Add More Users</a>?
            <br/>
            <br>
            Would you like to <a href="<c:url value='/addbook' />">Add More Books</a>?
            <br/>
            Go to <a href="<c:url value='/admin' />">Admin Page</a> OR <a href="<c:url value="/logout" />">Logout</a>
        </div>
    </div>
</body>
</html>