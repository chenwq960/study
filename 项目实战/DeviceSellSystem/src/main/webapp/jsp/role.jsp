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
		<table class="table tabl-hover table-striped table-bordered text-center">
			<tr>
				<td>序号：</td>
				<td>角色名称：</td>
				<td>创建时间：</td>
				<td>创建人：</td>
				<td>修改时间：</td>
				<td>修改人：</td>
				<!-- <td>是否删除：</td> -->
				<td>
					<button onclick="location.href='<%=path%>/jsp/roleAdd.jsp'">增加</button>
				</td>
			</tr>
			<c:forEach items="${rolemodel}" var="s">
				<tr>
					<td>${s.role_id}</td>
					<td>${s.role_name}</td>
					<td>${s.role_create_time}</td>
					<td>${s.role_create_person}</td>
					<td>${s.change_time}</td>
					<td>${s.role_change_person}</td>
					<%-- <td>${s.role_delete}</td> --%>
					<td>
						<button onclick="roledelete(${s.role_id})">删除</button>
						<button>修改</button>
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
			"<%=path%>/roledeleteMes.do",
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
		location.href="<%=path%>/roleFind.do?pageNum="+id
	}
</script>
</html>