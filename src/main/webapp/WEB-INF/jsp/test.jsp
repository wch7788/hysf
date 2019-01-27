<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<title>毕业设计网页测试</title>
</head>
<style>
#btn{
border-color: red;
background: white;
color:blue;
}
</style>
<body>
<div style="height: 100%;width: 100%;background-color: blue;">
<h1 align="center">毕业设计网站测试</h1>
<div align="center"><input id="content" type="text">
<button id="btn" style="height: 300px;width: 500px">测试</button></div>
</div>

</body>

<script >
$("#btn").click(function()
		{
	$.ajax({
	   data:{data:"www"},	
	   type:"POST",
	   url:"getajax",
	   dataType:'json',
	   
	   success:function(msg){
		   
		   alert(msg.three);
          
	   },
	   error:function(msg){
		   
		   alert("失败");
	   }
    });
	
	
	
});

</script>
</html>