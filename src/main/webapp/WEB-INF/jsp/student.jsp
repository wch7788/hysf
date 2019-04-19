<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            <button class="glyphicon glyphicon-search btn btn-default " type="button"></button>
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

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">
                    <span class="glyphicon glyphicon-user" style="margin-right: 10px"></span>学生个人详细信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group form-group-sm">
                        <label for="recipient-name" class="col-sm-2 control-label">姓名:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-name" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="recipient-number" class="col-sm-2 control-label">学号:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-number" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="recipient-sex" class="col-sm-2 control-label">性别:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-sex" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="recipient-phone" class="col-sm-2 control-label">联系方式:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-phone">
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="recipient-birthDay" class="col-sm-2 control-label">出生日期:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="recipient-birthDay" readonly="readonly">
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

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">

    // $('body').css('overflow','hidden');

    $(function () {
        var size = 8;
        var studentInfo = {
            'pageNum': 1,
            'pageSize': size
        }
        $.ajax({
            type: "POST",
            url: "/v1/student/list",
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
                            url: "/v1/student/list",
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

    $("#searchBtn").click(function () {
        var info = $(".form-control").val();
        var size = 8;
        var studentInfo = {
            'pageNum': 1,
            'pageSize': size,
            'name': info
        }
        $.ajax({
            type: "POST",
            url: "/v1/student/list",
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
                            'pageSize': size,
                            'name': info
                        }
                        $.ajax({
                            type: "POST",
                            url: "/v1/student/list",
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

    $("body").on('click', '#studentInfo', function () {
        let id=$(this).val();
        $.ajax({
            type: "GET",
            url: "/v1/student/getStudent/"+id,
            dataType: 'json',
            success:function (map) {
                let student=map.result;
                showStudent(student);
            },
            error:function (result) {
                alert(result);
            }
        })
    });


    $('#save').click(function () {
        Swal.fire({
            type: 'warning', // 弹框类型
            title: '修改信息', //标题
            text: "您确定要修改信息吗？",
            confirmButtonColor: '#3085d6',
            confirmButtonText: '确定',
            showCancelButton: true,
            cancelButtonColor: '#d33',
            cancelButtonText: "取消",
            focusCancel: true
        }).then((isConfirm)=>{
            if (isConfirm.value) {
                let student={
                    number:$("#recipient-number").val(),
                    phone:$("#recipient-phone").val()
                }
                $.ajax({
                    type: "POST",
                    url: "/v1/student/saveStudent",
                    data: JSON.stringify(student),
                    contentType: "application/json",
                    dataType: 'json',
                    success:function (map) {
                        Swal.fire("保存成功", "", "success").then((isConfirm)=>{
                            window.location.reload();
                        });
                    },
                    error:function (result) {
                        alert(result)
                    }
                })
            }
        });
    });


    function showTable(result, pageNumber, pageSize) {
        var list = result.result.dataList;
        var tbody = "<tr>" +
            "<th></th>" +
            "<th>姓名</th>" +
            "<th>班级</th>" +
            "<th>学号</th>" +
            "<th>操作</th>" +
            "</tr>";
        $.each(list, function (index, value) {
            var trs = "";
            trs += "<tr>\n" +
                "<td class=\"id\">" + (parseInt(index) + 1 + (pageNumber - 1) * pageSize) + "</td>" +
                "<td>" + value.name + "</td>" +
                "<td>" + value.classId + "</td>" +
                "<td>" + value.number + "</td>" +
                "<td><button class=\"btn btn-info\" id=\"studentInfo\" data-toggle=\"modal\" data-target=\"#exampleModal\" value=" + value.id + ">Info</button></td>\n" +
                "</tr>";
            tbody += trs;
        });


        $("tbody").html(tbody);
    };

    function showStudent(student) {
        $("#recipient-name").val(student.name)
        $("#recipient-birthDay").val(student.birthDay)
        $("#recipient-number").val(student.number)
        $("#recipient-phone").val(student.phone)
        $("#recipient-sex").val(student.sex);
    }

</script>

</body>
</html>