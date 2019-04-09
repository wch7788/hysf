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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>Student</h1>
<div>
    <table class="table">
        <tr>
            <th></th>
            <th>姓名</th>
            <th>班级</th>
            <th>学号</th>
            <th>操作</th>
        </tr>
        <tr>
            <td class="id">1</td>
            <td>XXX</td>
            <td>XXX</td>
            <td>XXX</td>
            <td><button class="btn btn-info">Info</button></td>
        </tr>
        <tr>
            <td class="id">2</td>
            <td>XXX</td>
            <td>XXX</td>
            <td>XXX</td>
            <td><button id="ABC" class="btn btn-info">Info</button></td>
        </tr>
    </table>

    <%--<nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>--%>
</div>
<div style="text-align: center;margin-top: 40%"><ul class="pagination"></ul></div>

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            type:"POST",
            url:"/v1/auth/list",
            data:{'pageNumber':1,'pageSize':10},
            dataType:'json',
            success:function (result) {
                 var totalPage=result.result;
                 console.log(totalPage)
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
                    }

                }
                $(".pagination").bootstrapPaginator(options)
            },
            error:function (err) {
                alert(err)
            }
        });



    })






</script>

</body>
</html>