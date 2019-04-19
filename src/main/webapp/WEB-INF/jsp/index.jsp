<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>毕业设计</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" href="">logo</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation">
                    <a href="#">当前用户：<span class="badge">${user.username}</span></a>
                </li>
                <li>
                    <a href="/">
                        <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="pageContainer">
    <div class="pageSidebar">
        <ul class="nav nav-stacked nav-pills">
            <li role="presentation">
                <a href="/forWord/student" target="mainFrame">
                    <span class="glyphicon glyphicon-user" style="margin-right: 20px"></span>学生管理
                </a>
            </li>
            <li role="presentation" id="paperList">
                <a href="/forWord/student" target="mainFrame">
                    <span class="glyphicon glyphicon-duplicate" style="margin-right: 20px"></span>试题管理
                </a>
                <ul class="nav nav-stacked nav-pills" style="display: none; ">
                    <li role="presentation">
                        <a href="/forWord/choice" target="mainFrame">
                            <span class="glyphicon glyphicon-font" style="margin-right: 20px"></span>选择题
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="/forWord/judge" target="mainFrame">
                            <span class="glyphicon glyphicon-ok" style="margin-right: 20px"></span>判断题
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="/forWord/text" target="mainFrame">
                            <span class="glyphicon glyphicon-comment" style="margin-right: 20px"></span>主观题
                        </a>
                    </li>
                </ul>
            </li>
            <li role="presentation">
                <a href="/forWord/paper" target="mainFrame">
                    <span class="glyphicon glyphicon-file" style="margin-right: 20px"></span>试卷管理
                    <ul class="nav nav-">

                    </ul>
                </a>
            </li>
        </ul>
</div>
<div class="pageContent">
    <iframe src="/forWord/judge" id="mainFrame" name="mainFrame"
             width="100%"  height="100%" frameBorder="0">
    </iframe>
</div>
</div>
<div class="footer">
    <p class="text-center">
        2019 &copy; hytc.
    </p>
</div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
    window.onload=function(){
        $.ajax({
            type:"GET",
            url:"/test",
            success:function (result) {
                console.log(result);

            },
            error:function (err) {
                alert("系统错误")
            }
        });
    };

    $("ul>li").click(function () {
        $(this).children(".nav").slideDown(500);
        $(this).siblings().children(".nav").slideUp(500)

    })

    $(".nav li").click(function() {
        $(".active").removeClass('active');
        $(this).addClass("active");
    });


</script>
</body>
</html>