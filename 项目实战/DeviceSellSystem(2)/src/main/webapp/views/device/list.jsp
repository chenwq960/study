<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<table class="table table-hover table-bordered table-striped text-center">
			<tr>
				<td>设备名称：</td>
				<td>设备编号：</td>
				<td>设备型号：</td>
				<td>创建人：</td>
				<td>创建时间：</td>
			</tr>
			<tr>
				<c:forEach items="${list}" var="s">
					<tr>
						<td>${s.deviceName}</td>
						
						<td>${s.deviceCode}</td>
						<td>${s.deviceModel}</td>
						<td>${s.createUserName}</td>
						<td>
							<fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>