<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Role To USER Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <div class="form-container">
        <h1>Add role to user</h1>
        <form:form method="POST" commandName="user">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Login Name</label>

                    <div class="col-md-7">
                        <form:input path="login" id="login" class="form-control input-sm"/>

                        <div class="has-error">
                            <form:errors path="name" class="help-inline"/>

                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name"> Add role</label>

                    <div class="col-md-7">
                        <form:select path="roles" items="${roles}" multiple="true" itemValue="id" itemLabel="roleName"
                                     class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="roles" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-actions floatRight">

                    <input type="submit" value="Add" class="btn btn-primary btn-sm"/> or <a
                        href="<c:url value='/addRoleToUser' />">Cancel</a>
                </div>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>