<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
	font {
	line-height: 45px;
}
</style>
</head>
<body>
	<div class="container">
			<input type="hidden" class="form-control" name="role_id">
		<div class="input-group">
			<font>用户姓名:</font>
			<input class="form-control" name="role_name">
		</div>
		<button onclick="changerole()">修改</button>
		<button onclick="window.history.back(-1);">返回</button>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$.post(
			"${ctx}/rolehx.do",
			{id:"${param.id}"},
			function(obj){
				$("input[name=role_id]").val(obj.role_id)
				$("input[name=role_name]").val(obj.role_name)
			}
		)
		
	})
//修改的方法
	function changerole(){
		$.post(
			"${ctx}/changerole.do",
			{
				name:$("input[name=role_name]").val(),
				id:	$("input[name=role_id]").val()
			},
			function(obj){
				if(obj != 0){
					alert("修改成功")
					location.href="${ctx}/roleFind.do"
				}
			}
		)
	}
</script>
</html>