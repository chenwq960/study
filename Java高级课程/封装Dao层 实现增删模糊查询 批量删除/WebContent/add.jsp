<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="javascript/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="javascript/jquery-1.8.3.js"></script>
</head>
<body>
	<div class="container">
		<form>
			<table class="table table-hover table-border">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Username：</td>
					<td><input type="text" name="username"></td>
				</tr>
			</table>
		</form>
		<button class="btn btn-info" id="mes">添加</button>
	</div>
</body>
<script type="text/javascript">
//添加的方法
	$(function(){
		$("#mes").click(function(){
			$.post(
				"addmes",
				$("form").serialize(),
				function(data){
					if(data != 0){
						location.href="list"
					}
				}
			)
		})
	})
</script>
</html>