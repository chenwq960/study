<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员表</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
	ul li {
      list-style: none;
      float: left;
      border: 1px solid gray;
      padding: 0px 5px;
      cursor: pointer;
      background-color: #EEEEEE;
      border-radius: 5px;
  }
  input{
  	width: 150px;
  }

  .number {
      color: blue;
  }
</style>
</head>
<body>
	<div class="container">
		<table class="table table-hover table-striped table-bordered text-center">
			<tr>
				<form action="${ctx}/roleFind.do">
					<div class="pull-left">
						<input name="modelName" value="${modelName}">
						<input type="submit" value="寻找" style="width: 50px;">
					</div>
					<div class="pull-right">
						起始：<input name="startTime" value="${startTime }">
						终止：<input name="endTime" value="${endTime }">
					</div>
				</form>
			</tr>
			<tr>
				<td>角色名称：</td>
				<td>创建时间：</td>
				<td>创建人：</td>
				<td>修改时间：</td>
				<td>修改人：</td>
				<td>操作：
					<button  onclick="location.href='${ctx}/views/user/createUser.jsp'">增加</button>
				</td>
			</tr>
			<c:forEach items="${role}" var="s">
				<tr>
					<td>${s.role_name}</td>
					<td>${s.create_time}</td>
					<td>${s.create_user}</td>
					<td>${s.update_time}</td>
					<td>${s.update_user}</td>
					<td>
						<button onclick="delrole(${s.role_id})">删除</button>
						<button onclick="location.href='${ctx}/views/user/updateUser.jsp?id=${s.role_id}'">修改</button>
						
					</td>
				</tr>
			</c:forEach>
			
			
		</table>
		<div class="row">
			<div class="pull-right">
                 <ul>
                     <li>${limitmodel.pageNum }/${limitmodel.pages },共${limitmodel.pages }</li>
                     <li onclick="getlimit(${limitmodel.prePage})">
                 << </li> <li class="number" onclick="getlimit(1)">1
                     </li>
                     <li onclick="getlimit(${limitmodel.nextPage})">>></li>
                   </ul>
             </div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function roledelete(id){
		$.post(
			"${ctx}/roledeleteMes.do",
			{id:id},
			function(obj){
				if(obj != 0){
					location.reload()
				}
			}
		)
	}
//改变页数的
	function getlimit(id){
		location.href="${ctx}/roleFind.do?pageNum="+id
	}
//删除的方法
	function delrole(id) {
		if(confirm("确认要删除吗")==true){
			$.post(
				"${ctx}/delrole.do",
				{id:id},
				function(obj){
					if(obj != 0){
						location.reload()
					}
				}
			)
		}else{
			
		}
	}
</script>
</html>