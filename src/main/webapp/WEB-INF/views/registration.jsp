<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="container">

        <jsp:include page="header.jsp"/>
        <div class="form-container">


            <h1>New User Registration Form</h1>

            <form:form method="POST" modelAttribute="user" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="name">First Name</label>

                        <div class="col-md-7">
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="lastName">Last Name</label>

                        <div class="col-md-7">
                            <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="lastName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="login">Login</label>

                        <div class="col-md-7">
                            <form:input type="text" path="login" id="login" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="login" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="password">Password</label>

                        <div class="col-md-7">
                            <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="password" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="email">Email</label>

                        <div class="col-md-7">
                            <form:input type="text" path="email" id="email" placeholder="test@test.com"
                                        class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="email" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="phone">Phone</label>

                        <div class="col-md-7">
                            <form:input type="number" path="phone" id="phone" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="phone" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                                    class="btn btn-primary btn-sm"
                                    href="<c:url value='/listAdmin' />">Cancel</a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                                    class="btn btn-primary btn-sm"
                                    href="<c:url value='/registration' />">Cancel</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form:form>

    </div>
</div>

</body>
</html>