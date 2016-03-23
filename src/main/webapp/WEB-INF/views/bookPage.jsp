<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <%--<div class="generic-container">--%>


    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Book page </span></div>
        <div class="tablecontainer">
            <form:form method="POST" action="findBookById" commandName="book">

                <label>Find by Id</label>
                <form:input type="text" path="id" id="id"/>

                <input type="submit" value="FindById">

            </form:form>
            <form:form method="POST" action="findBookByName" commandName="book">

                <label>Find by Id</label>
                <form:input type="text" path="name" id="name"/>

                <input type="submit" value="FindById">

            </form:form>
            <table class="table table-hover">
                <thead>

                <tr>
                    <th>Book ID</th>
                    <td>${book.id}</td>
                </tr>
                <tr>
                    <th>Book Name</th>
                    <td>${book.name}</td>
                </tr>
                <tr>
                    <th>Book infoe</th>
                    <td>${book.info}</td>
                </tr>
                <tr>
                    <th>Author</th>
                    <td>${book.author}</td>
                </tr>
                <tr>
                    <th>Style</th>
                    <td>${book.style}</td>
                </tr>
                <%--<tr><td><a href="<c:url value='/download-document-${book.id}' />" class="btn btn-success custom-width">Download</a></td></tr>--%>
                <%--<tr><td><a href="<c:url value='/edit-book-${book.id}' />" class="btn btn-success custom-width">edit</a> </td></tr>--%>
                <%--<tr><td><a href="<c:url value='/delete-book-${book.id}' />" class="btn btn-danger custom-width">delete</a></td></tr>--%>
                <%--<tr><td><a href="<c:url value='/add-to-list-book-${book.id}' />" class="btn btn-danger custom-width">add bookto list</a></td></tr>--%>
                </thead>
                </tbody>
            </table>
        </div>
    </div>
    <sec:authorize access="hasRole('USER')">
    <div class="well">

        <a href="<c:url value='/download-document-${book.id}' />" class="btn btn-success custom-width">Download</a>
        <a href="<c:url value='/delete-book-${book.id}' />" class="btn btn-danger custom-width">delete</a>
        <a href="<c:url value='/add-to-list-book-${book.id}' />" class="btn btn-danger ">add bookto list</a>

        <a href="<c:url value='/addbook' /> " class="btn btn-danger ">Add New Book</a>
    </div>
    <%--</div>--%>
    </sec:authorize>

</div>
<!-- /container -->
</body>
</html>