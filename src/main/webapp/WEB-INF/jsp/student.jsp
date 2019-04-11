<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生信息页面</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/load.css">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
</head>
<body>
<div class="spinner">
    <div class="rect1"></div>
    <div class="rect2"></div>
    <div class="rect3"></div>
    <div class="rect4"></div>
    <div class="rect5"></div>
</div>
<h3><span class="glyphicon glyphicon-tasks">学生信息管理</span></h3>
<div class="col-lg-6" style="margin-left: -10px">
    <div class="input-group">
        <span class="input-group-btn">
            <button class="glyphicon glyphicon-search btn btn-default " type="button" ></button>
        </span>
        <input type="text" class="form-control" placeholder="Search for...">
        <span class="input-group-btn">
            <button class="btn btn-success" type="button" id="searchBtn">Search</button>
        </span>
    </div>
</div>
<div class="page-header"></div>
<div>
    <table class="table table-striped table-hover" style="table-layout:fixed">
        <tbody></tbody>
    </table>
</div>

<div style="text-align: right;margin-bottom: 10%">
    <ul class="pagination"></ul>
</div>

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">

   // $('body').css('overflow','hidden');

    $(function () {
        var size=8;
        var studentInfo={
            'pageNum':1,
            'pageSize':size
        }
        $.ajax({
            type:"POST",
            url:"/v1/student/list",
            data:JSON.stringify(studentInfo),
            contentType:"application/json",
            dataType:'json',
            beforeSend:function(){
                $(".spinner").show();
            },
            success:function (result) {
                $(".spinner").hide();
                var totalPage=result.result.pageInfo.totalPage;
                if(totalPage==0){
                    totalPage=1;
                }
                showTable(result,1,size);
                var options={
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
                    onPageClicked:function(event,originalEvent,type,page){
                             var studentPage={
                                 'pageNum':page,
                                 'pageSize':size
                             }
                             $.ajax({
                                 type:"POST",
                                 url:"/v1/student/list",
                                 data:JSON.stringify(studentPage),
                                 contentType:"application/json",
                                 dataType:'json',
                                 beforeSend:function(){
                                     $(".spinner").show();
                                 },
                                 success:function (result) {
                                     $(".spinner").hide();
                                     showTable(result,page,size);
                                 }

                             })
                    }
                }
                $(".pagination").bootstrapPaginator(options)
            },
            error:function (err) {
                alert(err)
            }
        });



    });

    $("#searchBtn").click(function () {
         var info=$(".form-control").val();
         var size=8;
         var studentInfo={
             'pageNum':1,
             'pageSize':size,
             'name': info
         }
         $.ajax({
             type:"POST",
             url:"/v1/student/list",
             data:JSON.stringify(studentInfo),
             contentType:"application/json",
             dataType:'json',
             beforeSend:function(){
                 $(".spinner").show();
             },
             success:function (result) {
                 $(".spinner").hide();
                 var totalPage=result.result.pageInfo.totalPage;
                 if(totalPage==0){
                     totalPage=1;
                 }
                 showTable(result,1,size);
                 var options={
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
                     onPageClicked:function(event,originalEvent,type,page){
                         var studentPage={
                             'pageNum':page,
                             'pageSize':size,
                             'name':info
                         }
                         $.ajax({
                             type:"POST",
                             url:"/v1/student/list",
                             data:JSON.stringify(studentPage),
                             contentType:"application/json",
                             dataType:'json',
                             beforeSend:function(){
                                 $(".spinner").show();
                             },
                             success:function (result) {
                                 $(".spinner").hide();
                                 showTable(result,page,size);
                             }

                         })
                     }
                 }
                 $(".pagination").bootstrapPaginator(options)
             },
             error:function (err) {
                 alert(err)
             }
         });
     });

    $("body").on('click','#studentInfo',function () {
        window.location.href="/forWord/studentInfo"
        console.log($(this).val())
    });










    function showTable(result,pageNumber,pageSize) {
        var list=result.result.dataList;
        var tbody="<tr>"+
            "<th></th>"+
            "<th>姓名</th>"+
            "<th>班级</th>"+
            "<th>学号</th>"+
            "<th>操作</th>"+
            "</tr>";
        $.each(list,function (index,value){
            var trs="";
            trs+="<tr>\n" +
                "<td class=\"id\">"+(parseInt(index)+1+(pageNumber-1)*pageSize)+"</td>" +
                "<td>"+value.name+"</td>" +
                "<td>"+value.classId+"</td>" +
                "<td>"+value.number+"</td>" +
                "<td><button class=\"btn btn-info\" id=\"studentInfo\" value="+value.id+">Info</button></td>\n" +
                "</tr>";
            tbody+=trs;
        });

        $("tbody").html(tbody);
    };

</script>

</body>
</html>