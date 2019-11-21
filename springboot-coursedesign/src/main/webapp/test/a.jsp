<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/11/20
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        $(document).ready(function(){
            $("button").click(function(){
                $.ajax({url:"/a",
                    success:function(result){
                        $("#div1").html(result);
                    }});
            });
        });
    </script>
</head>
<body>

<div id="div1"><h2>使用 jQuery AJAX 修改文本内容</h2></div>
<button>获取其他内容</button>

</body>
</html>