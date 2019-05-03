<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 101 Template</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/load.css">
</head>
<body>

<h3><span class="glyphicon glyphicon-plus"> 添加新的试卷</span></h3>
<h5 class="page-header"></h5>
<button type="button" class="btn btn-success" id="addJudgeBtn" data-toggle="modal" data-target="#addJudgeModal">添加判断题</button>
<button type="button" class="btn btn-success" id="addChoiceBtn" data-toggle="modal" data-target="#addChoiceModal">添加选择题</button>
<button type="button" class="btn btn-success" id="addTextBtn" data-toggle="modal" data-target="#addTextModal">添加主观题</button>
<div class="page-header"></div>
<form class="form-inline">
    <div class="form-group">
        <label for="paperTitle">试卷标题：</label>
        <input type="text" class="form-control" id="paperTitle" placeholder="请输入试卷标题">
    </div>
    <div class="form-group" style="margin-left: 50px">
        <label for="paperCourse">所属科目：</label>
        <select class="form-control" id="paperCourse">
            <option value="1001">数学</option>
            <option value="1002">语文</option>
        </select>
    </div>
</form>

<div  style="margin-top: 40px">
    <h3><span class="label label-primary">判断题</span></h3>
    <div id="judgeList"></div>
</div>
<div  style="margin-top: 40px">
    <h3><span class="label label-info">选择题</span></h3>
    <div id="choiceList"></div>
</div>
<div  style="margin-top: 40px">
    <h3><span class="label label-success">主观题</span></h3>
    <div id="textList"></div>
</div>

<div class="page-header" style="margin-top: 60px"></div>
<div  style="text-align: center;margin-top: 60px">
    <button id="submit" class="btn btn-primary" style="margin-right: 20px">确定</button>

    <button id="cancel" class="btn btn-danger" style="margin-left: 20px">取消</button>
</div>

<div class="modal fade" id="addJudgeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">判断题选项</h4>
            </div>
            <div class="modal-body">
                <form id="judgeForm"></form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="addJudgeCheckBtn" data-dismiss="modal">添加</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addChoiceModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel2">选择题选项</h4>
            </div>
            <div class="modal-body">
                <form id="choiceForm"></form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="addChoiceCheckBtn" data-dismiss="modal">添加</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addTextModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel3">主观题选项</h4>
            </div>
            <div class="modal-body">
                <form id="textForm"></form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="addTextCheckBtn" data-dismiss="modal">添加</button>
            </div>
        </div>
    </div>
</div>

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">


    $("#cancel").click(function (){
        window.location.href="/forWord/paper"
    })

    $("#addJudgeBtn").click(function (){
        var judgeInfo = {
            'pageNum': 0,
            'pageSize': 0
        }
        $.ajax({
            type: "POST",
            url: "/v1/judge/list",
            data: JSON.stringify(judgeInfo),
            contentType: "application/json",
            dataType: 'json',
            success:function (map){
                let result=map.result;
                showList(result,'judge');
            }
        })
    });

    $("#addChoiceBtn").click(function (){
        let choiceInfo = {
            'pageNum': 0,
            'pageSize': 0
        }
        $.ajax({
            type: "POST",
            url: "/v1/choice/list",
            data: JSON.stringify(choiceInfo),
            contentType: "application/json",
            dataType: 'json',
            success:function (map){
                let result=map.result;
                showList(result,'choice');
            }
        })
    });

    $("#addTextBtn").click(function (){
        let choiceInfo = {
            'pageNum': 0,
            'pageSize': 0
        }
        $.ajax({
            type: "POST",
            url: "/v1/text/list",
            data: JSON.stringify(choiceInfo),
            contentType: "application/json",
            dataType: 'json',
            success:function (map){
                let result=map.result;
                showList(result,'text');
            }
        })
    });

    function showList(result,type) {
        let str='';
        let className='';
        if(type=='judge'){
            className='judgeCheck'
        }else if (type=='choice'){
            className='choiceCheck'
        } else{
            className='textCheck'
        }
        $.each(result.dataList,function (index,value){
               str+="<div class=\"form-group\">\n" +
                   "                        <input type=\"checkbox\" class=\""+className+"\" value=\""+value.id+"\">\n" +
                   "                        <label  class=\"control-label\">题目"+(index+1)+":</label>\n" +
                   "                        <textarea class=\"form-control\"  readonly=\"readonly\">"+value.question+"</textarea>\n" +
                   "                    </div>"
        })
        if(type=='judge'){
            $("#judgeForm").html(str);
        }else if (type=='choice'){
            $("#choiceForm").html(str);
        } else{
            $('#textForm').html(str);
        }

    }

    $("#addJudgeCheckBtn").click(function (){
        let str='';
        $(".judgeCheck").each(function(index,value) {
            let checked=$(this).prop('checked');
            if(checked){
                let id=$(this).val()
                str+="<span class=\"label label-default\">"+id+"</span>"
            }
        })
        $("#judgeList").html(str);
    })

    $("#addChoiceCheckBtn").click(function (){
        let str='';
        $(".choiceCheck").each(function(index,value) {
            let checked=$(this).prop('checked');
            if(checked){
                let id=$(this).val()
                str+="<span class=\"label label-default\">"+id+"</span>"
            }
        })
        $("#choiceList").html(str);
    })

    $("#addTextCheckBtn").click(function (){
        let str='';
        $(".textCheck").each(function(index,value) {
            let checked=$(this).prop('checked');
            if(checked){
                let id=$(this).val()
                str+="<span class=\"label label-default\">"+id+"</span>"
            }
        })
        $("#textList").html(str);
    })



    $("#submit").click(function (){
        Swal.fire({
            type: 'warning', // 弹框类型
            title: '新增试卷', //标题
            text: "您确定要添加试卷吗？",
            confirmButtonColor: '#3085d6',
            confirmButtonText: '确定',
            showCancelButton: true,
            cancelButtonColor: '#d33',
            cancelButtonText: "取消",
            focusCancel: true
        }).then((isConfirm)=>{
            if (isConfirm.value) {
                let judgeArr=eachJudge();
                let choiceArr=eachChoice();
                let textArr=eachText();
                let paper={
                    info:$("#paperTitle").val(),
                    courseId:$("#paperCourse").val(),
                    teacherId:'1001',
                    judgeList:judgeArr,
                    choiceList:choiceArr,
                    textList:textArr
                }
                $.ajax({
                    type: "POST",
                    url: "/v1/paper/addPaper",
                    data: JSON.stringify(paper),
                    contentType: "application/json",
                    dataType: 'json',
                    success:function (map){
                        Swal.fire("保存成功", "", "success").then((isConfirm)=>{
                            window.location.href="/forWord/paper"
                        });
                    }
                })
            }
        });
    })

    function eachJudge() {
        let arr = new Array();
        $("#judgeList span").each(function (index, value) {
            let judgeId = $(this).text()
            arr.push(judgeId);
        })
        return arr;
    }

    function eachChoice() {
        let arr=new Array();
        $("#choiceList span").each(function (index,value){
            let choiceId=$(this).text();
            arr.push(choiceId);
        })
        return arr;
    }

    function eachText() {
        let arr=new Array();
        $("#textList span").each(function (index,value){
            let textId=$(this).text();
            arr.push(textId);
        })
        return arr;
    }
</script>
</body>
</html>