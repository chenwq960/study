<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String path = request.getContextPath();%>
<title>Insert title here</title>
<script src="<%=path%>/javascript/jquery-1.8.3.js"></script>
<link href="<%=path%>/javascript/bootstrap.min.css" rel="stylesheet"/>
<script src="<%=path%>/javascript/jquery.cookie.js"></script>
</head>
<body>
	
</body>
<script type="text/javascript">
	$(function(){
		alert(${param.id})
	})
</script>
</html>