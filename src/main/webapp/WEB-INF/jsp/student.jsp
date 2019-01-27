<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
<table border="1" align="center">
<tr>
<th>序号</th>
<th>姓名</th>
<th>年龄</th>
<th>班级</th>
<th>地址</th>
<th>操作</th>
</tr>
<c:forEach var="stu" items="${students}">
<tr>
<td>${stu.id}</td>
<td>${stu.name}</td>
<td>${stu.age}</td>
<td>${stu.classroom.name}</td>
<td>${stu.address.address}</td>
<td><a href="delete?id=${stu.id}">删除</a>
<a href="update?id=${stu.id}">修改</a>
</td>
</tr>

</c:forEach>
</table>
</form>
</body>
</html>