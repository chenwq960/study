<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	margin: 0px auto;
}
td, th {
	text-align: center;
	padding: 5px 7px;
}

tr{
	background:gray;
}
tr:hover {
	background:white;
}
</style>
<title>Insert title here</title>
</head>
<body>

<form action="find" method="post">
	车名：<input type="text" name="name" value="">
	价格:<input type="text" name="priceUp" value="0">
	至
	<input type="text" name="priceEnd" value="0">
	<input type="submit" value="查询">
</form>
	<table border="1">
		<tr>
			<th>id编号：</th>
			<th>车名称：</th>
			<th>车价格：</th>
			<th>车颜色：</th>
			<th>车种类：</th>
			<th>车ID：</th>
			<th>出车时间：</th>
		</tr>
		<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.price}</td>
				<td>${s.color}</td>
				<td>${s.type}</td>
				<td>${s.typeid}</td>
				<td>${s.date}</td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>