<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Users List</title>
  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
  <div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">List of Users </span></div>
    <div class="tablecontainer">
      <table class="table table-hover">
        <thead>
        <tr>
          <th>Book ID</th>
          <th>Book Name</th>
          <th>Book infoe</th>
          <th>Author</th>
          <th>Style</th>
          <th width="100"></th>
          <th width="100"></th>
          <th width="100"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="user">
          <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.info}</td>
            <td>${book.author}</td>
            <td>${book.style}</td>
            <td><a href="<c:url value='/edit-book-${book.id}' />" class="btn btn-success custom-width">edit</a></td>
            <td><a href="<c:url value='/edit-book-${book.id}' />" class="btn btn-success custom-width">edit</a></td>
            <td><a href="<c:url value='/delete-book-${book.id}' />" class="btn btn-danger custom-width">delete</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <div class="well">
    <a href="<c:url value='/addbook' />">Add New User</a>
  </div>
</div>
</body>
</html>