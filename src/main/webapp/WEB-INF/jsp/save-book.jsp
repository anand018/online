<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Book</title>
</head>
<body>

	<form:form modelAttribute="bookForm" enctype="multipart/form-data">
		<span style="color: red"> 
		<form:errors path="*" /> 
		</span>
		Title:
		<form:input path="title" /> <br>
		Author:
		<form:input path="author" /> <br>
		Edition:
		<form:input path="edition" /> <br>
		Publisher:
		<form:input path="publisher" /> <br>
		ISBN:
		<form:input path="isbn" /> <br>
		Catagory:
		<form:input path="category" /><br>
		Book:
		<input type="file" class="file" name="originalBook" /><br>
		Cover:
		<input type="file" class="file" name="coverPage" />
		<input type="submit" name="save" value="save">
	</form:form>
</body>

</html>