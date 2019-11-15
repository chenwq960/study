<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button>按钮</button>
	<div></div>

</body>
<script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			$.ajax({
				url:"list",
				data:{id:"mes"},
				type:"post",
				success:function(data){
					for(var i in data){
						$("div").append(data[i].id)
					}
				}
			})
		})
	})
</script>
</html>