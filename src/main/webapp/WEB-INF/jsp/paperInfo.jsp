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

<h3><span class="glyphicon glyphicon-star">试卷详情页</span></h3>
<div class="page-header"></div>




<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/sweetAlert2.all.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script type="text/javascript">
   $(function (){
       let paperId=sessionStorage.getItem("paperId");
       $.ajax({
           type: "GET",
           url: "/v1/paper/info/"+paperId,
           dataType: 'json',
           success: function (map) {
               let result=map.result;
               showList(result);
           },
           error:function (err) {
               alert(err);
           }

       });
   })

    function showList(result) {
        let judgeList=result.judgeList;
        let choiceList=result.choiceList;
        let textList=result.textList;
        let str='';
        if(judgeList.length!=0){
            str+="<h3><span class=\"label label-danger\">判断题</span></h3>\n"
        }
        $.each(judgeList,function (index,value){
            str+="<div class=\"panel panel-info\">\n" +
                "        <div class=\"panel-heading\">"+"问题:"+value.question+"</div>\n" +
                "        <div class=\"panel-foot\">\n" +
                "答案:"+value.answer +
                "        </div>\n" +
                "    </div>"
        });
        if(choiceList.length!=0){
            str+="<h3><span class=\"label label-danger\">选择题</span></h3>\n"
        }
        $.each(choiceList,function (index,value){
            str+="<div class=\"panel panel-primary\">\n" +
                "        <div class=\"panel-heading\">问题:"+value.question+"</div>\n" +
                "        <div class=\"panel-body\">\n" +
                "            选项A："+value.choiceOne+"\n" +
                "        </div>\n" +
                "        <div class=\"panel-body\">\n" +
                "            选项B："+value.choiceTwo+"\n" +
                "        </div>\n" +
                "        <div class=\"panel-body\">\n" +
                "            选项C："+value.choiceThree+"\n" +
                "        </div>\n" +
                "        <div class=\"panel-body\">\n" +
                "            选项D："+value.choiceFour+"\n" +
                "        </div>\n" +
                "        <div class=\"panel-foot\">\n" +
                "           答案:"+value.answer+"\n" +
                "        </div>\n" +
                "    </div>"
        });
        if(textList.length!=0){
            str+="<h3><span class=\"label label-danger\">主观题</span></h3>\n"
        }
        $.each(textList,function (index,value){
            str+="<div class=\"panel panel-success\">\n" +
                "        <div class=\"panel-heading\">"+"问题:"+value.question+"</div>\n" +
                "        <div class=\"panel-foot\">\n" +
                "答案:"+value.answer +
                "        </div>\n" +
                "    </div>"
        });

        $("body").append(str);
    }

</script>
</body>
</html>