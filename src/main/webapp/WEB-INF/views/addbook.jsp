<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User Registration Form</title>
  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="form-container">

  <h1>New User Registration Form</h1>

  <form:form method="POST" modelAttribute="book" class="form-horizontal">

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="name">Book Name</label>
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
        <label class="col-md-3 control-lable" for="info">Book info</label>
        <div class="col-md-7">
          <form:input type="text" path="info" id="info" class="form-control input-sm"/>
          <div class="has-error">
            <form:errors path="info" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="author">author</label>
        <div class="col-md-7">
          <form:input type="text" path="author" id="author" class="form-control input-sm"/>
          <div class="has-error">
            <form:errors path="author" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-group col-md-12">
        <label class="col-md-3 control-lable" for="style">style</label>
        <div class="col-md-7">
          <form:input type="text" path="style" id="style" class="form-control input-sm"/>
          <div class="has-error">
            <form:errors path="style" class="help-inline"/>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="form-actions floatRight">
        <input type="submit" value="addBook" class="btn btn-primary btn-sm"> or <a href="<c:url value='/admin' />">Cancel</a>
      </div>
    </div>
  </form:form>
</div>
</body>
</html>