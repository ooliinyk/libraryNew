<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>

<body>
	<div class="success">
		Greeting : ${greeting}
		This is a welcome page.

	</div>


		<form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" >

					<label  for="file">Upload a document</label>

						<form:input type="file" path="file" id="file" />

							<form:errors path="file" class="help-inline"/>


					<label class="col-md-3 control-lable" for="file">Description</label>

						<form:input type="text" path="description" id="description" />


					<input type="submit" value="Upload" >

		</form:form>

</body>
</html>