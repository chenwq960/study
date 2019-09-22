<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
这里是列表
<table id="one" border="1" width="750" style="float:left">
        <tr>
        	<th width=120>
        		<button onclick="deleteAll()">批量删除</button><br/>
        		<input type="checkbox" id="checkAll" onclick="checkAll()"/>
        	</th>
        	<td width="30">序号</td>
        	<th width="150">ID</th>
        	<th width="150">用户名</th>
        	<th width="150">年齡</th>
        	<th width="150"><button onclick="toAdd()">添加</button></th>
        </tr>
        <c:forEach items="${list}" var="user">
        <tr>
           <th><input type="checkbox" name="checkOne" value="${user.id}"/></th>
           <td>${user.id}</td>
           <td>${user.name}</td>
           <td>${user.age}</td>
           <th>
           		<button onclick="deleteOne(${user.id})">删除</button>
           		<button onclick="toup(${user.id})">修改</button>
           </th>
        </tr>
        </c:forEach>
        <tr>
           <th>模糊查询：</th>
           <form action="<%=request.getContextPath()%>/userServlet.do?m=like" method="post"><th>
           		<input type="text" name="userName"/></th><th>
           		<input type="submit" value="模糊查询"/></th>
           </th></form>
           <td colspan="2" id="info"></td>
        </tr>
    </table>
</body>
</html>