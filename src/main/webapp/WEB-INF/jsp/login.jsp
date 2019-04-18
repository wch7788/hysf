<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=" <%=basePath%>"> 
<title>毕业设计网页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" media="screen" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/reset.css"/>
</head>

<body>
<div id="particles-js">
		<div class="login">
	    <img alt="" src="picture/logo.png">
			<div class="login-top" style="text-align: center;margin-left: -50px;font-weight: bold;">
				登录
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" name="username" value="123" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" name="password"value="123456" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-button" >
				登录
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>


<script src="js/particles.min.js"></script>
<script src="js/app.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/sweetAlert2.all.min.js"></script>
<script type="text/javascript">
	function hasClass(elem, cls) {
	  cls = cls || '';
	  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
	  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}
	 
	function addClass(ele, cls) {
	  if (!hasClass(ele, cls)) {
	    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
	  }
	}
	 
	function removeClass(ele, cls) {
	  if (hasClass(ele, cls)) {
	    var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
	    while (newClass.indexOf(' ' + cls + ' ') >= 0) {
	      newClass = newClass.replace(' ' + cls + ' ', ' ');
	    }
	    ele.className = newClass.replace(/^\s+|\s+$/g, '');
	  }
	}

		
		$(".login-button").click(function(){

			var basePath = "<%=basePath%>";
			console.log(basePath)
		    var user={username:$("input[name='username']").val(),
				      password:$("input[name='password']").val()}
				      console.log(JSON.stringify(user));
	        $.ajax({
	            type:"POST",
	            url:"v1/auth/login",
	            data:JSON.stringify(user),
				contentType: 'application/json; charset=UTF-8',
				dataType:'json',
	            success:function (result) {
	            	console.log(result);
	                if("OK"==result.status){
	                window.location.href="/index"
	                }else{
						swal.fire({title:result.message,type: 'warning',showConfirmButton: false});
	                    $("input[name='password']").val("");  //将密码input清空
	                    $("input[name='password']").focus();  //将光标定位到密码input
	                }
	            },
	            error:function (err) {
					swal.fire("系统错误", "", "error")
	            }
	        });

		})
		
</script>
</body>
</html>