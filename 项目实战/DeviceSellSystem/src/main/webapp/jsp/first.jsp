<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
%>
<link href="${ctx}/javascript/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/javascript/style.css" rel="stylesheet">
<script src="${ctx}/javascript/jquery-1.8.3.js"></script>
</head>
<body>
	<div>
		<nav>
			<div class="container">
				<div class="pull-left col-md-10 text-left">
					<h3>销售管理系统</h3>
				</div>
				<div class="pull-right col-md-2" id="userModel">欢迎</div>
			</div>

		</nav>
		<div class="container">
			<div class="row">
				<div class="col-md-2 pull-left text-center left">
					<div class="row">
						<a id="user">人员管理</a>
					</div>
					<div class="row">
						<a onclick="role()">角色管理</a>
					</div>
					<div class="row">
						<a onclick="department()">部门管理</a>
					</div>
					<div class="row">
						<a>销售管理</a>
					</div>
				</div>
				<div class="col-md-9 pull-left right">
					<iframe class="col-md-12" src=""></iframe>

				</div>
			</div>

		</div>
	</div>
	</div>
	</div>
</body>
<script type="text/javascript">
	
	function department(){
		$("iframe").attr("src", '${ctx}/departmentFind.do');
	}
	function role(){
		$("iframe").attr("src", '${ctx}/roleFind.do');
	}
	
	$(function(){
		$("#userModel").append("${param.username}")
	});
</script>
</html>