<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Here are all books</p>
	<center>
		<table>
			<tr>
				<c:forEach var="book" items="${books}">
					<tr align="center" style="color: blue">
						<td>${book.publisher}</td>
						<img src=${pageContext.request.contextPath}/${book.covers} alt="Italian Trulli">
						<td><img src=${book.covers} alt="cover"></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</center>
</body>
</html>