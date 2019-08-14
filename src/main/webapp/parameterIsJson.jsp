<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function reques_json(){
		var user = {};
		user.name="lina";
		user.age = 22;
		console.log(JSON.stringify(user));
		$.ajax({
			url:"${pageContext.request.contextPath}/requestJson.do",
			type:'post',
			contentType:'application/json;charset=utf-8',//请求内容为json
			data:JSON.stringify(user),
			success:function(data){
				console.log(data);
			}
		})
	} 
	function formsubmit(){
		var user = "name=lilei&age=24";
		console.log(user);
		$.ajax({
			url:"${pageContext.request.contextPath}/responseJson.do",
		  //ContentType没指定将默认为：application/x-www-form-urlencoded
			type:"post",
			data:user,
			success:function(data){
				console.log(data);
			}
			
		});
	}
</script>
</head>
<body>
	<input type="button" value="请求json返回json" onclick="reques_json()">
	<input type="button" value="请求key/value返回json" onclick="formsubmit()">
</body>
</html>