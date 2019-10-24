<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upmes" method="post">
		序列号：<input type = "text" name = "number" value="${stu.id}"><br/>
		标题：<input type = "text" name ="title" value="${stu.title}"><br/>
		用户名：<input type = "text" name="name" value="${stu.name}"><br/>
		<input type="submit" value="修改">
		<input type ="reset" value="重置">
	</form>

</body>
</html>