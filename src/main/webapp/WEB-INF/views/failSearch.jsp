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
      ERROR
      Confirmation message : ${fail}

    </div>
  </div>
</body>
</html>