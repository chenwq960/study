<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link href="javascript/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="javascript/jquery-1.8.3.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-hover table-bordered text-center">
			<tr>
				<td colspan="10">
					<span>请输入要搜索的姓名</span>
					<input type="text" value="${name}" name="name">
					<input type="button" class="btn btn-success" value="搜索" onclick="message()">
				</td>
			</tr>
			<tr>
				<td>选项：</td>
				<td>姓名：</td>
				<td>username：</td>
				<td>ID:</td>
				<td>
					<button class="btn btn-info" onclick="addmessage()">添加</button>
				</td>
			</tr>
			<c:forEach items="${list}" var="s">
				<tr>
					<td><input type="checkbox" value="${s.id}"></td>
					<td>${s.name1 }</td>
					<td>${s.name2}</td>
					<td>${s.id}</td>
					<td>
						<button class="btn btn-success" class="deleteId" name="id" value="${s.id}">删除</button>
						<input value="修饰"  class="btn" type="button" >
					</td>
				</tr>
			</c:forEach>
		</table>
		<button class="btn btn-warning" onclick="show(true)">全选</button>
		<button class="btn btn-warning" onclick="show(false)">全不选</button>
		<button class="btn btn-warning" onclick="show()">全选</button>
		<button class="btn btn-info" onclick="deletemessageId()">删除</button>
	</div>
</body>
<script type="text/javascript">
	$(function(){
	//删除的方式
		$("button[name=id]").click(function(){
			$.post(
				"delete",
				{delmes:$(this).val()},
				function(data){
					if(data != 0){
						location.reload()
					}
				}
			)
		})
	})
//所有的方法
	function message(){
		location="list?name="+$("input[name=name]").val()
	}
//添加的方法
	function addmessage(){
		location.href="add.jsp"
	}
//全选   全不选  等等操作
	function show(flag){
		$("input:checkbox").each(function(){
			
			$(this).prop("checked",!$(this).prop("checked"))
		}),
		$("input:checkbox").prop("checked",flag)
	}
///删除全部
	function deletemessageId(){
		var count = "";
		$("input:checked").each(function(){
			count+=","+$(this).val()
		})
		$.post(
			"deleteAll",
			{id:count},
			function(data){
				if(data != 0){
					location.reload()
				}
			}
		)
	}
	
</script>
</html>