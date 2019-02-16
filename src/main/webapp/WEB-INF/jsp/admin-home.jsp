<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 align="left" style="font-family: sans-serif;">HOWARD</h2>

	<a href="${pageContext.request.contextPath}/logout">Logout</a>

	<center>
		<p style="font-family: sans-serif; size: 20px">Welcome to HOWARD
			Library</p>

		<a href="${pageContext.request.contextPath}/register.htm">Click
			here to register</a> <a
			href="${pageContext.request.contextPath}/save-book.htm">Click
			here to add a book</a>
	</center>
</body>
</html>