<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Title</title>

    <link href="/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/load.css">
</head>
<body>
<h3><span class="glyphicon glyphicon-download">成绩查看</span></h3>
<h5 class="page-header"></h5>
<form class="form-inline">
    <div class="form-group" style="margin-left: 50px">
        <label for="course">所属科目：</label>
        <select class="form-control" id="course">
            <option value="1001">数学</option>
            <option value="1002">语文</option>
        </select>
    </div>
    <div class="form-group" style="margin-left: 50px">
        <label for="date">考试日期：</label>
        <select class="form-control" id="date">
            <option value="2019-05-02">2019年5月1日</option>
            <option value="2019-06-01">2019年6月1日</option>
        </select>
    </div>

    <button type="button" class="btn btn-success" id="download" style="margin-left: 50px">导出成绩单</button>
</form>

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">
    $("#download").click(function () {
        let date=$("#date").val();
        let courseId=$("#course").val();
        window.location.href="/v1/grade/export?courseId="+courseId+"&date="+date
    })
</script>
</body>
</html>