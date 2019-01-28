<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>首页</title>
		<link rel="stylesheet" href="css/page.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/index.js" ></script>
	</head>

	<body>
		<div class="left">
			<div class="bigTitle">商圈后台管理系统</div>
			<div class="lines">
				<div onclick="pageClick(this)" class="active"><img src="img/icon-1.png" />业务人员管理</div>
				<div onclick="pageClick(this)"><img src="img/icon-2.png" />代理商品管理</div>
				<div onclick="pageClick(this)"><img src="img/icon-3.png" />个人信息管理</div>
				<div onclick="pageClick(this)"><img src="img/icon-4.png" />收货地址管理</div>
				<div onclick="pageClick(this)"><img src="img/icon-5.png" />在售门店管理</div>
			</div>
		</div>
		<div class="top">
			<div class="leftTiyle" id="flTitle">业务人员管理</div>
			<div class="thisUser">当前用户：小UU</div>
		</div>
		<div class="content">HELLO WORD</div>
		

		
	</body>

</html>