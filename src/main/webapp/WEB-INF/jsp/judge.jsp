<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>判断题</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/load.css">
</head>
<body>
<div class="spinner">
    <div class="rect1"></div>
    <div class="rect2"></div>
    <div class="rect3"></div>
    <div class="rect4"></div>
    <div class="rect5"></div>
</div>
<h3><span class="glyphicon glyphicon-tags"> 试题管理-判断题</span></h3>
<div class="col-lg-6" style="margin-left: -10px">
    <div class="input-group">
        <span class="input-group-btn">
            <button class="glyphicon glyphicon-search btn btn-default " type="button"></button>
        </span>
        <input type="text" class="form-control" placeholder="Search for...">
        <span class="input-group-btn">
            <button class="btn btn-success" type="button" id="searchBtn">Search</button>
        </span>
    </div>
</div>
<button type="button" class="btn btn-primary" id="addBtn" data-toggle="modal" data-target="#addJudgeModal">新增判断题</button>

<div class="page-header"></div>
<div>
    <table class="table table-striped table-hover" style="table-layout:fixed">
        <tbody></tbody>
    </table>
</div>

<div style="text-align: right;margin-bottom: 10%">
    <ul class="pagination"></ul>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">
                    <span class="glyphicon glyphicon-star" style="margin-right: 10px"></span>判断题详细信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group form-group-sm">
                        <label for="recipient-courseName" class="col-sm-2 control-label">科目:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-courseName" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="recipient-level" class="col-sm-2 control-label">难度:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-level" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="recipient-question" class="col-sm-2 control-label">题目:</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" id="recipient-question"></textarea>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="recipient-answer" class="col-sm-2 control-label">答案</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-answer">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addJudgeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >
                    <span class="glyphicon glyphicon-plus" style="margin-right: 10px"/>新增判断题</h4>
            </div>
            <div style="margin-top: 10px;margin-left: 10px">
                <button type="button" class="btn btn-success" id="addMoreJudge">同时添加多条</button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="judgeQuestion">
                        <div class="form-group">
                            <label for="course-select" class="control-label">科目:</label>
                            <select id="course-select" class="form-control">
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="control-label">题目:</label>
                            <textarea class="form-control" id="message-text"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" class="control-label">答案:</label>
                            <input type="text" class="form-control" id="recipient-name">
                        </div>
                        <div>
                            <button type="button" class="btn btn-danger" id="remove">删除</button>
                        </div>
                    </div>
                    <h5 class="page-header"></h5>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="sumbit">提交</button>
            </div>
        </div>
    </div>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">
   $(function () {
       var size = 8;
       var judgeInfo = {
           'pageNum': 1,
           'pageSize': size
       }
       $.ajax({
           type: "POST",
           url: "/v1/judge/list",
           data: JSON.stringify(judgeInfo),
           contentType: "application/json",
           dataType: 'json',
           beforeSend: function () {
               $(".spinner").show();
           },
           success: function (result) {
               $(".spinner").hide();
               var totalPage = result.result.pageInfo.totalPage;
               if (totalPage == 0) {
                   totalPage = 1;
               }
               showTable(result, 1, size);
               var options = {
                   bootstrapMajorVersion: 3,
                   currentPage: 1,
                   totalPages: totalPage,
                   itemTexts: function (type, page, current) {
                       switch (type) {
                           case "first":
                               return "第一页";
                           case "prev":
                               return "上一页";
                           case "next":
                               return "下一页";
                           case "last":
                               return "最后一页";
                           case "page":
                               return page;
                       }
                   },
                   onPageClicked: function (event, originalEvent, type, page) {
                       var judgeInfo = {
                           'pageNum': page,
                           'pageSize': size
                       }
                       $.ajax({
                           type: "POST",
                           url: "/v1/judge/list",
                           data: JSON.stringify(judgeInfo),
                           contentType: "application/json",
                           dataType: 'json',
                           beforeSend: function () {
                               $(".spinner").show();
                           },
                           success: function (result) {
                               $(".spinner").hide();
                               showTable(result, page, size);
                           }

                       });
                   }
               }
               $(".pagination").bootstrapPaginator(options)
           },
           error: function (err) {
               alert(err)
           }
       });

       var str=getQuestionType()
       $("#course-select").html("");
       $("#course-select").append(str);
   });

   function getQuestionType(){
       var str="";
   $.ajax({
           type: "GET",
           async: false,
           url: "/v1/judge/getQuestionType/judge",
           dataType: 'json',
           success: function (map) {
               let questionType=map.result;
               $(questionType).each(function (index,value) {
                   str+="<option value=\""+value.id+"\">"+"所属课程:"+value.courseName+","+"难度:"+value.level+"</option>\n"
               })
           }
       });
       return str;
   }

   $("body").on('click', '#judgeInfo', function () {
       let id=$(this).val();
       $.ajax({
           type: "GET",
           url: "/v1/judge/getJudge/"+id,
           dataType: 'json',
           success:function (map) {
               console.log(map)
               let judge=map.result;
               showJudge(judge);
           },
           error:function (result) {
               alert(result);
           }
       })
   });

   $("body").on('click', '#remove', function () {
       $(this).parents(".judgeQuestion").next(".page-header").remove()
       $(this).parents(".judgeQuestion").remove()
   });


   $('#save').click(function () {
       Swal.fire({
           type: 'warning', // 弹框类型
           title: '修改题目', //标题
           text: "您确定要修改题目吗？",
           confirmButtonColor: '#3085d6',
           confirmButtonText: '确定',
           showCancelButton: true,
           cancelButtonColor: '#d33',
           cancelButtonText: "取消",
           focusCancel: true
       }).then((isConfirm)=>{
           if (isConfirm.value) {
               let judgeInfo={
                   id:$(this).val(),
                   question:$("#recipient-question").val(),
                   answer:$("#recipient-answer").val()
               }
               console.log(judgeInfo)
                $.ajax({
                   type: "POST",
                   url: "/v1/judge/updateJudge",
                   data: JSON.stringify(judgeInfo),
                   contentType: "application/json",
                   dataType: 'json',
                   success:function (map) {
                       Swal.fire("保存成功", "", "success").then((isConfirm)=>{
                           window.location.reload();
                       });
                   },
                   error:function (result) {
                       alert("系统错误")
                   }
               })
           }
       });
   });

   $("#sumbit").click(function () {
       var judgeList=new Array();

       $(".judgeQuestion").each(function(index,element){
           let judge={
               questionId:$(this).find("#course-select").val(),
               answer:$(this).find("input").val(),
               question:$(this).find("textarea").val()
           }
           console.log($(this).find("textarea").val())
           judgeList.push(judge)
       });

       $.ajax({
           type: "POST",
           url: "/v1/judge/addJudge",
           data: JSON.stringify(judgeList),
           contentType: "application/json",
           dataType: 'json',
           success:function (map) {
               Swal.fire("保存成功", "", "success").then((isConfirm)=>{
                   window.location.reload();
               });
           },
           error:function (result) {
               alert("系统错误")
           }
       })

   })

   $("#addMoreJudge").click(function () {
       var str=getQuestionType();
       const s = "<div class=\"judgeQuestion\">\n" +" <div class=\"form-group\">\n" +
           "                            <label for=\"course-select\" class=\"control-label\">科目:</label>\n" +
           "                            <select id=\"course-select\" class=\"form-control\">\n" +str+
           "                            </select>\n" +
           "                        </div>"+
           "                        <div class=\"form-group\">\n" +
           "                            <label for=\"message-text\" class=\"control-label\">题目:</label>\n" +
           "                            <textarea class=\"form-control\" id=\"message-text\"></textarea>\n" +
           "                        </div>\n" +
           "                        <div class=\"form-group\">\n" +
           "                            <label for=\"recipient-name\" class=\"control-label\">答案:</label>\n" +
           "                            <input type=\"text\" class=\"form-control\" id=\"recipient-name\">\n" +
           "                        </div>\n" +
           "                        <div>\n" +
           "                            <button type=\"button\" class=\"btn btn-danger\" id=\"remove\">删除</button>\n" +
           "                        </div>\n" +
           "                    </div>\n" +
           "                    <h5 class=\"page-header\"></h5>"
       $("#addJudgeModal").find("form").append(s)
   })


   function showTable(result, pageNumber, pageSize) {
       var list = result.result.dataList;
       var tbody = "<tr>" +
           "<th></th>" +
           "<th>所属题型编号</th>" +
           "<th>所属科目</th>" +
           "<th>试题难度</th>" +
           "<th>操作</th>" +
           "</tr>";
       $.each(list, function (index, value) {
           var trs = "";
           trs += "<tr>\n" +
               "<td class=\"id\">" + (parseInt(index) + 1 + (pageNumber - 1) * pageSize) + "</td>" +
               "<td>" + value.questionId + "</td>" +
               "<td>" + value.courseName + "</td>" +
               "<td>" + value.level + "</td>" +
               "<td><button class=\"btn btn-info\" id=\"judgeInfo\" data-toggle=\"modal\" data-target=\"#exampleModal\" value=" + value.id + ">题目详情</button></td>\n" +
               "</tr>";
           tbody += trs;
       });
       $("tbody").html(tbody);
   };

   function showJudge(judge) {
       $("#recipient-courseName").val(judge.courseName)
       $("#recipient-level").val(judge.level)
       $("#recipient-question").val(judge.question)
       $("#recipient-answer").val(judge.answer)
       $("#save").val(judge.id);
   }

</script>
</body>
</html>