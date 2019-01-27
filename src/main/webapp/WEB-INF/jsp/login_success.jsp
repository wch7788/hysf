<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!doctype html>
<html lang="en">
<head>

	<meta charset="UTF-8">
	<title>Document</title>
	<script>
		/************************************************************/
		/************************************************************/
		/******************* 《可修改区域-开始》 ********************/
		/************************************************************/
		// 此处需要修改链接，修改跳转后的链接
		var url = "homepage";
		/************************************************************/
		/******************* 《可修改区域-结束》 ********************/
		/************************************************************/
		/************************************************************/

		window.onload = function () {
			function bb() {
				var num = Number(number.innerHTML);
				var min = 0;
				function id ()  {
					num--;
					number.innerHTML = num;
					if (num == min) {
						window.location = url;
					} else {
						setTimeout(id, 1000);
					}
				}
				setTimeout(id, 1000);
			}
			bb();
		};
	</script>
</head>
<style>



body {
	background: #F7F7F7;
}
#all {
	width: 300px;
	height: 500px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -150px;
	margin-top: -250px;
}
#img {
	width: 300px;
	height: 300px;
	background: url("123.gif");
	
	
}
.info {
	margin-top: 10px;
	text-align: center;
}
a {
	color: blue;
}
a:hover {
	color: #f60;
}
.time {
	color: #FF7C7C;
	font-weight: bold;
}



</style>
<body>
	<div id="all">

		<div id="img"></div>
		<div class="info">
			<!-- ****************************************************** -->
			<!-- 此处需要修改链接 -->
			<span class="time"><span id="number">99</span>秒</span> 后自动跳转，也可<a href="homepage">点击此处直接跳转</a>
			<!-- ****************************************************** -->
		</div>
	</div>
</body>
</html>
