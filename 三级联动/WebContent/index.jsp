<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	请选择省份：<select id='s' onchange="mchange()"></select>
	请选择市份：<select id='m' onchange="hchange()"></select>
	请选择县：<select id="h"></select>
	
</body>
<script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$.post(
			"list",
			{id:1},
			function(data){
				for(var i in data){
					var s = data[i]
					$("#s").append("<option value="+s.id+">"+s.name+"</option>")
				}
				mchange()
			},"JSON"
		)
		
		
	})
	function mchange(){
		$("#m").empty()
		var id = $("#s").val();
		$.post(
			"list",
			{id:id},
			function(data){
				for(var i in data){
					var a = data[i]
					$("#m").append("<option value="+a.id+">"+a.name+"</option>")
				}
				hchange()
			},"json"
		)
	}
	
	//县城
	function hchange(){
		$("#h").empty()
		var id = $("#m").val()
		$.post(
			"list",
			{id:id},
			function(data){
				for(var i in data){
					var a = data[i]
					$("#h").append("<option value="+a.id+">"+a.name+"</option>")
				}
			},"json"
		)
	}
	

</script>
</html>