<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register yourself</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: blue;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password], input[type=email] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus, input[type=email]:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.signupbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 49%;
	opacity: 0.9;
}

.signupbtn:hover {
	opacity: 1;
}

.cancelbtn {
	background-color: #8b8e8b;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 49%;
	opacity: 0.9;
}

.cancelbtn:hover {
	opacity: 1;
}
/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
</head>
<body>

	<h2 align="left" style="font-family: sans-serif; color: white">HOWARD University Library</h2>

	<div class="container">
		<h2 style="font-family: sans-serif;">Register Here</h2>

		<form:form modelAttribute="registerForm">
			<span style="color: red"> <form:errors path="*" />
			</span>

			<table>
				<tr>
					<td>First name</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last name</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:input path="gender" /></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><form:input path="dob" /></td>
				</tr>
				<tr>
					<td>Email Address</td>
					<td><form:input path="emailAddress" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="password"  /></td>
				</tr>
				<tr>
					<td>Re enter password</td>
					<td><form:input path="rePassword" /></td>
				</tr>
			</table>

			<div class="clearfix">
				<button type="submit" class="signupbtn">Sign Up</button>
				<button type="button" class="cancelbtn">Cancel</button>
			</div>

			<!--  <input type="submit" value="register" />-->
		</form:form>

	</div>
</body>
</html>