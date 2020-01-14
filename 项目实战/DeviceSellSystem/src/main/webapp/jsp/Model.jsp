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
<style>
    iframe {
    padding-top:30px;
        width:95%;
        height:1000px;
        border-radius:10px;
        border:3px solid red;
    }
   	header{
   		border-radius:20px;
   		height:30px;
   		margin-bottom:30px;
   		font-size:30px;
   		line-height:50px;
   	}
   	.main{
   		border: 1px blue;
   		height:500px;
   	}
   	button{
   		margin:15px 20px;
   	}
</style>
</head>
<body>	
	 <div class="container">
	 	<header class="text-center">
	 		欢迎用户
	 	</header>
	 	<div class="main">
	 		<div class="pull-right col-md-10">
	 			<iframe src="http://localhost:8080/FindalDemo/departmentFind.do"></iframe>
	 		</div>
	 		<div class="pull-left col-md-2 text-center">
	 			<button class="btn btn-warning">人员表:</button><br/>
	 			<button class="btn btn-success" onclick="role()">角色表:</button><br/>
	 			<button class="btn btn-info" onclick="departement()">部门表:</button><br/>
	 		</div>
	 	</div>
	 </div>
</body>
<script type="text/javascript">
	$(function(){
		$("header").append(${param.username})
	});
	
	function departement(){
		alert("进入部门表")
		$("iframe").attr("src", 'http://localhost:8080/FindalDemo/departmentFind.do');
	};
	function role(){
		$("iframe").attr("src", 'http://localhost:8080/FindalDemo/roleFind.do');
	}
</script>
</html>