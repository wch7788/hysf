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
            <option selected value="0">请选择科目</option>
        </select>
    </div>
    <div class="form-group" style="margin-left: 50px">
        <label for="date">考试日期：</label>
        <select class="form-control" id="date">
        </select>
    </div>

    <button type="button" class="btn btn-success" id="download" style="margin-left: 50px">导出成绩单</button>
</form>

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">
    $(function (){
        $.ajax({
            type: "get",
            url: "/v1/grade/getGradeCourse",
            dataType: 'json',
            success:function (map){
                let result=map.result;
                showGradeCourse(result);
            }
        });
    });



    $("#course").change(function () {
        let courseId=$("#course").val();
        $.ajax({
            type: "get",
            url: "/v1/grade/getGradeDate/"+courseId,
            dataType: 'json',
            success:function (map){
                let result=map.result;
                showDate(result);
            },
            error:function (err) {
                alert("系统错误")
            }
        });
    });

    function showGradeCourse(result){
        let str='';
        $.each(result,function (index,value){
            str+="<option value=\""+value.courseId+"\">"+value.courseName+"</option>"
        })
        $("#course").append(str);
    }

    function showDate(result){
        let str='';
        $.each(result,function (index,value){
            str+="<option value=\""+value+"\">"+value+"</option>"
        })
        $("#date").html(str);
    }

    $("#download").click(function () {
        let date=$("#date").val();
        let courseId=$("#course").val();
        if(courseId==0||date==null){
            alert("请选择科目以及时间")
        }else{
            window.location.href="/v1/grade/export?courseId="+courseId+"&date="+date
        }
    })
</script>
</body>
</html>