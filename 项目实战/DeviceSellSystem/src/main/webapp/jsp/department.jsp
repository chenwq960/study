<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String path = request.getContextPath();%>
<title>人员表</title>
<script src="<%=path%>/javascript/jquery-1.8.3.js"></script>
<link href="<%=path%>/javascript/bootstrap.min.css" rel="stylesheet"/>
<script src="<%=path%>/javascript/jquery.cookie.js"></script>
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

  .number {
      color: blue;
  }
</style>
</head>
<body>
	<div class="container">
		<table class="table table-hover table-bordered table-striped">
			<tr>
				<td>x序列号：</td>
				<td>部门名称：</td>
				<td>创建时间：</td>
				<td>创建人：</td>
				<td>修改时间：</td>
				<td>修改人：</td>
				<!-- <td>是否删除：</td> -->
				<td>操作：
					<button class="btn btn-info" onclick="location.href='<%=path%>/jsp/departmentAdd.jsp'">增加</button>
				</td>
			</tr>
			<c:forEach items="${department}" var="s">
				<tr>
					<td>${s.department_id}</td>
					<td>${s.department_name}</td>
					<td>${s.create_time}</td>
					<td>${s.create_user}</td>
					<td>${s.update_time}</td>
					<td>${s.update_user}</td>
					<%--<td>${s.de_delete}</td> --%>
					<td>
						<%-- <button onclick="departmentChangeById()" class="btn btn-success">修改</button>
						<button onclick="del(${s.de_id})" class="btn btn-warning">删除</button> --%>
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
	function del(id){
		$.post(
			"<%=path%>/departmentByIdDel.do",
			{id:id},
			function(obj){
				if(obj != 0){
					location.reload()
				}
			}
		)
	}
	function getlimit(id){
		location.href="<%=path%>/departmentFind.do?pageNum="+id
	}
</script>
</html>