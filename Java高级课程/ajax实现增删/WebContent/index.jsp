<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/css.css">
<style type="text/css">
	table {
	
	margin: 30px auto;
}
	td,th{
		padding: 10px;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>序列号：</th>
			<th>编号：</th>
			<th>姓名：</th>
			<th>性别：</th>
			<th>爱好：</th>
			<th>生日：</th>
			<th>部门：</th>
			<th>操作  |  <button>添加</button></th>
		</tr>
		<c:forEach items="${list}" var="s">
			<tr>
				<td><input type="checkbox" value="${s.id}"></td>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.gender}</td>
				<td>${s.hobby}</td>
				<td>${s.birth}</td>
				<td>${s.deptName}</td>
			</tr>
		</c:forEach>
		
		
		
	</table>
		<input type="button" value="全选" onclick="show(true)"><br/>
		<input type="button" value="全不选" onclick="show(false)"><br/>
		<input type="button" value="反选" onclick="show()"><br/>
		<input type="button" value="删除" onclick="del()"><br/>

</body>
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button:first").click(function(){
			location.href="add.jsp"
			
		})
		
	})
	function show(b){
		$("input:checkbox").each(function(){
			
			$(this).prop("checked",!$(this).prop("checked"))
		}),
		$("input:checkbox").prop("checked",b)
	}
	//删除
	function del(){
		var result = ""
		$("input:checked").each(function(){
			console.log($(this).val())
			result += ","+$(this).val()
		})
		
		$.post(
			"del",
			{id:result},
			function(data){
				if(data != 0){
					location.href="list"
				}
			}
		)
		
		
	}
	
</script>






















</html>