<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
 <% String number =  session.getAttribute("number").toString();%>
 <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet"/>
<script src="${ctx}/javascript/jquery.cookie.js"></script>
<script src="${ctx}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
				  <font>部门名称</font>
				  <select id="sel" class="form-control" name="department_name">
				  	<option>选择部门</option>
				  </select>
				</div>
				
				<input type="hidden" class="form-control" name="department_id">
			</div>
			<input type="button" onclick="updatedepartment()" value="提交数据" class="btn btn-info" >
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$.post(
			"${ctx}/departmenthx.do",
			{id:"${param.id}"},
			function(obj){
				console.log(obj)
				$("input[name=department_id]").val(obj.department_id)
				$("input[name=create_time]").val(obj.create_time)
				$("input[name=create_user]").val(obj.create_user)
				$("input[name=update_time]").val(obj.update_time)
				$("input[name=update_user]").val(obj.update_user)
				departmentfind()
			}
		)
	})
	function departmentfind(){
		$.post(
			"${ctx}/departmentfind.do",
			function(obj){
				console.log(obj)
				for(let i in obj){
					var name = obj[i]
					$("#sel").append("<option>"+name.department_name+"</option>")
				}
			}
		)
		
	}
//修改数据的提交
	function updatedepartment(){
		$.post(
			"${ctx}/updatedepartment.do",
				$("form").serialize(),
				function(obj){
				console.log("obj")
			}
		)
}
</script>
</html>