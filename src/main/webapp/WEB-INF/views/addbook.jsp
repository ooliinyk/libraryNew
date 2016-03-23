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
<div class="container">
  <jsp:include page="header.jsp"/>
<div class="form-container">

  <h1>New Book Registration Form</h1>

  <form:form method="POST" modelAttribute="book" class="form-horizontal">
    <form:input type="hidden" path="id" id="id"/>

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

        <c:choose>
          <c:when test="${edit}">
            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listAdmin' />">Cancel</a>
          </c:when>
          <c:otherwise>
            <input type="submit" value="addBook" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/listAdmin' />">Cancel</a>
          </c:otherwise>
        </c:choose>
       </div>
    </div>

    <c:if test="${edit}">
			<span class="well pull-left">
				<a href="<c:url value='/add-document-${book.id}' />">Click here to upload/manage your documents</a>
			</span>
    </c:if>
  </form:form>
</div>
  </div>
  </div>
</body>
</html>