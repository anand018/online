<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h2 align="left" style="font-family: sans-serif;">HOWARD</h2>

	<h2 align="right">
		<%
			if (request.getAttribute("user") != null)
				out.print(request.getAttribute("user"));
		%>
	</h2>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
	<center>
		<p style="font-family: sans-serif; size: 20px">Welcome to HOWARD
			Library</p>

		<a href="${pageContext.request.contextPath}/login.htm">Login </a>
		<p></p>
		<a href="${pageContext.request.contextPath}/register.htm">Register</a>

		<h3 style="color: red">AVAILABLE BOOKS</h3>
		<table align="center">
			<tr>
				<c:forEach var="book" items="${books}">
					<td align="center"><img alt="img" height="300" width="200"
						src="data:image/jpeg;base64,${book.covers}" /> ${book.publisher}</td>
				</c:forEach>
			</tr>
		</table>
		<h2>
			<%
				if (request.getAttribute("empty") != null)
					out.print(request.getAttribute("empty"));
			%>
		</h2>
	</center>
</body>
</html>