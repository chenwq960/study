<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>ID：</td>
			<td>姓名：</td>
			<td>年龄：</td>
			
		</tr>
		<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.id}</td>
			<td>${s.name}</td>
			<td>${s.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>