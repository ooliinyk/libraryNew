<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>
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
        <div class="panel-heading"><span class="lead">Hello ${user.login}</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>User ID</th>
                    <td>${user.id}</td>
                </tr>
                <tr>
                    <th>User Name</th>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <th>User Last Name</th>
                    <td>${user.lastName}</td>
                </tr>
                <tr>
                    <th>Book infoe</th>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <th>Author</th>
                    <td>${user.phone}</td>
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

    <div class="panel panel-default">
    <div class="panel-heading"><span class="lead">Favorites books </span></div>
    <div class="tablecontainer">
        <%--<form:form method="POST"  action="findBookById"  commandName="book" >--%>

        <%--<label >Find by Id</label>--%>
        <%--<form:input type="text" path="id" id="id" />--%>

        <%--<input type="submit" value="FindById" >--%>

        <%--</form:form>--%>
        <%--<form:form method="POST"  action="findBookByName"  commandName="book" >--%>

        <%--<label >Find by Id</label>--%>
        <%--<form:input type="text" path="name" id="name" />--%>

        <%--<input type="submit" value="FindById" >--%>

        <%--</form:form>--%>

        <%--<form:form method="POST"  action="findBookByStyle"  commandName="book" >--%>

        <%--<label >Find by Id</label>--%>
        <%--<form:input type="text" path="style" id="style" />--%>

        <%--<input type="submit" value="FindById" >--%>

        <%--</form:form>--%>

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
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                        <td>${book.info}</td>
                        <td>${book.author}</td>
                        <td>${book.style}</td>
                        <td><a href="<c:url value='/book-${book.id}' />"
                               class="btn btn-success custom-width">BookPage</a></td>
                            <%--<td><a href="<c:url value='/edit-book-${book.id}' />" class="btn btn-success custom-width">edit</a> </td>--%>
                            <%--<td><a href="<c:url value='/delete-book-${book.id}' />" class="btn btn-danger custom-width">delete</a></td>--%>
                            <%--<td><a href="<c:url value='/add-to-list-book-${book.id}' />" class="btn btn-danger custom-width">add bookto list</a></td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<div class="well">
    <a href="<c:url value='/registration' />">Add New User</a>
</div>
</div>
</body>
</html>