<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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


    <!-- Main  -->

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Books </span></div>
        <div class="tablecontainer">


            <div class="row">
                <div class="col-lg-6">

                    <form:form method="POST" action="findBookById" commandName="book">

                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable">Find by Id</label>

                            <div class="col-md-7">
                                <form:input type="number" path="id" id="id"/>
                                <input type="submit" value="Find">

                                <div class="has-error">
                                    <form:errors type="text" path="id"/>
                                </div>

                            </div>
                        </div>


                    </form:form>
                </div>
                <div class="col-lg-6 ">
                    <form:form method="POST" action="findBookByName" commandName="book">


                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable">Find by Name</label>

                            <div class="col-md-7">
                                <form:input type="text" path="name" id="name"/>
                                <input type="submit" value="Find">

                                <div class="has-error">
                                    <form:errors type="text" path="name"/>
                                </div>

                            </div>
                        </div>


                    </form:form>
                </div>
                <div class="col-lg-6 ">
                    <form:form method="POST" action="findBookByStyle" commandName="book">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable">Find by Style</label>

                            <div class="col-md-7">
                                <form:input type="text" path="style" id="style"/>
                                <input type="submit" value="Find">

                                <div class="has-error">
                                    <form:errors type="text" path="style"/>
                                </div>

                            </div>
                        </div>


                    </form:form>
                </div>
                <div class="col-lg-6 ">
                    <form:form method="POST" action="findBookByAuthor" commandName="book">

                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable">Find by Author</label>

                            <div class="col-md-7">
                                <form:input type="text" path="author" id="author"/>
                                <input type="submit" value="Find">

                                <div class="has-error">
                                    <form:errors type="text" path="author"/>
                                </div>

                            </div>

                        </div>


                    </form:form>
                </div>

            </div>




            <div class="tablecontainer">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Book ID</th>
                        <th>Book Name</th>
                        <th>Book infoe</th>
                        <th>Author</th>
                        <th>Style</th>
                        <sec:authorize access="hasRole('USER')">
                            <th width="100"></th>
                            <th width="100"></th>
                            <th width="100"></th>
                            <th width="100"></th>
                        </sec:authorize>
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

                            <sec:authorize access="hasRole('USER')">
                                <%--<td><a href="<c:url value='/edit-book-${book.id}' />"--%>
                                <%--class="btn btn-success custom-width">edit</a></td>--%>
                                <td><a href="<c:url value='/download-document-${book.id}' />"
                                       class="btn btn-success custom-width">Download</a>
                                </td>
                                <td><a href="<c:url value='/add-to-list-book-${book.id}' />"
                                       class="btn btn-danger ">add to favorite</a>
                                </td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="well">
        <a href="<c:url value='/addbook' />">Add New User</a>
    </div>

</div>
<!-- /container -->


</body>
</html>