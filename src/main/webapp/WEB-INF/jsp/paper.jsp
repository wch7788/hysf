<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
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
<h3><span class="glyphicon glyphicon-tags"> 试卷信息管理</span></h3>
<div class="page-header"></div>
<button type="button" class="btn btn-primary" id="addBtn" >新增试卷</button>

<div style="margin-top: 10px">
    <table class="table table-striped table-hover" style="table-layout:fixed">
        <tbody></tbody>
    </table>
</div>
<div style="text-align: right;margin-bottom: 10%">
    <ul class="pagination"></ul>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">

    $(function () {
        var size = 8;
        var studentInfo = {
            'pageNum': 1,
            'pageSize': size
        }
        $.ajax({
            type: "POST",
            url: "/v1/paper/list",
            data: JSON.stringify(studentInfo),
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
                        var studentPage = {
                            'pageNum': page,
                            'pageSize': size
                        }
                        $.ajax({
                            type: "POST",
                            url: "/v1/paper/list",
                            data: JSON.stringify(studentPage),
                            contentType: "application/json",
                            dataType: 'json',
                            beforeSend: function () {
                                $(".spinner").show();
                            },
                            success: function (result) {
                                $(".spinner").hide();
                                showTable(result, page, size);
                            }

                        })
                    }
                }
                $(".pagination").bootstrapPaginator(options)
            },
            error: function (err) {
                alert(err)
            }
        });

    });

    function showTable(result, pageNumber, pageSize) {
        var list = result.result.dataList;
        var tbody = "<tr>" +
            "<th></th>" +
            "<th>试卷info</th>" +
            "<th>所属学科</th>" +
            "<th>所属教师</th>" +
            "<th>创建时间</th>" +
            "<th>操作</th>" +
            "</tr>";
        $.each(list, function (index, value) {
            var trs = "";
            trs += "<tr>\n" +
                "<td class=\"id\">" + (parseInt(index) + 1 + (pageNumber - 1) * pageSize) + "</td>" +
                "<td>" + value.info + "</td>" +
                "<td>" + value.courseName + "</td>" +
                "<td>" + value.teacherName + "</td>" +
                "<td>" + value.createDate + "</td>" +
                "<td><button class=\"btn btn-info\" id=\"paperInfo\"  value=" + value.id + ">试卷详情</button></td>\n" +
                "</tr>";
            tbody += trs;
        });


        $("tbody").html(tbody);
    };

    $("body").on('click', '#paperInfo', function () {
        let paperId=$(this).val();
        sessionStorage.setItem("paperId",paperId)
        window.location.href="/forWord/paperInfo"
    });

    $("#addBtn").click(function (){
        window.location.href="/forWord/addPaper"
    })

</script>
</body>
</html>