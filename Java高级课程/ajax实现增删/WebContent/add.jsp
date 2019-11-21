<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<label>
			编号：
			<input type="text" name="id">
		</label>
		<br/>
		
		<label>
			姓名：
			<input type="text" name="name">
		</label>
		<br/>
		
		<label>
			性别：
			<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女
		</label>
		<br/>
		
		<label>
			爱好：
			<input type="checkbox" name="val" value="跑步">跑步
			<input type="checkbox" name="val" value="爬山">爬山
			<input type="checkbox" name="val" value="足球">足球
			<input type="checkbox" name="val" value="太极">太极
			<input type="checkbox" name="val" value="音乐">音乐
			<input type="checkbox" name="val" value="其他">其他
		</label>
		<br/>
		
		<label>
			生日：
			<input type="text" name="birth">
		</label>
		<br/>
		
		<label>
			部门：
			<input type="text" name="department">
		</label>
		<br/>
		<input type="button" value="提交">
	</form>

</body>
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[type=button]").click(function(){
			$.post(
				"add",
				$("form").serialize(),
				function(data){
					if(data != 0){
						location.href="list"
					}
				}
			)
		})
		
	})
</script>
</html>