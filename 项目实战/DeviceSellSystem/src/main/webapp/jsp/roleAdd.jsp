<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String path = request.getContextPath();%>
<title>人员表</title>
<script src="<%=path%>/javascript/jquery-1.8.3.js"></script>
<link href="<%=path%>/javascript/bootstrap.min.css" rel="stylesheet"/>
<script src="<%=path%>/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	font{
		font-size: 16px;
		line-height:45px;
	}
</style>
</head>

<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
				  <font>角色名称</font>
				  <input type="text" class="form-control" name="role_name">
				</div>
				<div class="input-group">
					<font>创建时间:</font>
					<input class="form-control" name="role_create_time" onfocus="WdatePicker()">
				</div>
				<div class="input-group">
					<font>创建人：</font>
					<input class="form-control" name="role_create_person">
				</div>
				<div class="input-group">
					<font>修改时间：</font>
					<input class="form-control" name="change_time"  onfocus="WdatePicker()">
													
				</div>
				<div class="input-group">
					<font>修改人：</font>
					<input class="form-control" name="role_change_person">
				</div>
			</div>
			<input type="submit" value="提交数据" class="btn btn-info">
		</form>
	</div>
</body>
<script type="text/javascript">
	$("input[type=submit]").click(function(){
		$.post(
				"<%=path%>/roleAddmessage.do",
				$("#form").serialize(),
				function(obj){
					alert(obj)
				}
			)
	})
</script>
</html>