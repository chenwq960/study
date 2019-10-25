<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	margin-top: 50px;
	margin: 0px auto;
}

th, td {
	text-align: center;
	padding: 5px 10px;
}
div{
	border:3px solid gray;
	padding:5px;
	width:700px;
	text-align: center;
	margin: 10px auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="find" method="post">
			序列号：<input type="text" name="id" value="">
			标题字：<input type="text" name="title" value="">
			姓名：<input type="text" name="name" value="">
			<input type="submit" value="查找">
		</form>
	</div>




	<table border="1">
		<tr>
			<th>序列号:</th>
			<th>标语:</th>
			<th>姓名:</th>
		</tr>
		<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.title}</td>
				<td>${s.name}</td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>