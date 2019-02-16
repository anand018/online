<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WhatsApp Home</title>
</head>
<body style="background-color: #FA8072">

	<form:form modelAttribute="userDataForm">
		<span style="color: red"> <form:errors path="*" />
		</span>
		<br>
		<br>
		<label>Mobile Number</label>
		<form:input path="mobile" />
		<br>

		<label>Message</label>
		<form:input path="message" />
		<br>

		<input type="submit" value="register" />
	</form:form>

</body>
</html>