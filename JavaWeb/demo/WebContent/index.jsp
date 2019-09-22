<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
这里是首页,<br>
<a href="<%=request.getContextPath()%>/userServlet.do?m=toAdd">跳转页面User2</a>
<a href="<%=request.getContextPath()%>/userServlet.do?m=toList">跳转页面List</a>
</body>
</html>