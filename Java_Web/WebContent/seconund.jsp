<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie [] cs = request.getCookies();
	if(cs != null){
		for(Cookie s: cs){
			if("name".equals(s.getName())){
				String name = s.getValue();
				pageContext.setAttribute("name",name);
			}
			if("pass".equals(s.getName())){
				String pass = s.getValue();
				pageContext.setAttribute("pass",pass);
			}
		}
	}
%>
	<h1>注册成功</h1>
	<form action="again" method="post">
		登录——姓名：<input type="text" name = "username" value="${name}"><br/>
		登录——密码：<input type="text" name = "password" value="${pass}"><br/>
		<input type="checkbox" name="cb">记住密码<br/>
		<input type="submit" value="登录">
		<input type="reset" value="重置">
	</form>
</body>
</html>