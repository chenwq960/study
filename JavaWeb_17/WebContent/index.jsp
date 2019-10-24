<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	th,td{
		text-align: center;
		padding:5px 7px;
	}
	table {
	margin: 0px auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>序列号：</th>
			<th>标题：</th>
			<th>姓名：</th>
			<td>修改：</td>
		</tr>
		<c:forEach items="${list }" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.title}</td>
				<td>${s.name}</td>
				<td>
					<a href="del?id=${s.id}">删除</a>
					<a href="change?id=${s.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>