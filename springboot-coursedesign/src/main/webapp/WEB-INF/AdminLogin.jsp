<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/11/21
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlogin/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlogin/orionicons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlogin/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlogin/custom.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/adminlogin/favicon.png?3">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
<div class="page-holder d-flex align-items-center">
    <div class="container">
        <div class="row align-items-center py-5">
            <div class="col-5 col-lg-7 mx-auto mb-5 mb-lg-0">
                <div class="pr-lg-5">
                    <img src="${pageContext.request.contextPath}/static/adminlogin/illustration.svg" alt="" class="img-fluid">
                </div>
            </div>
            <div class="col-lg-5 px-lg-4">
                <h1 class="text-base text-primary text-uppercase mb-4">Bubbly Dashboard</h1>
                <h2 class="mb-4">Welcome back!</h2>
                <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>
                <form id="loginForm" onsubmit="return false" action="/##" class="mt-4" method="post">
                    <div class="form-group mb-4">
                        <input type="text" name="id" placeholder="UserId or Email address" class="form-control border-0 shadow form-control-lg">
                    </div>
                    <div class="form-group mb-4">
                        <input type="password" name="password" placeholder="Password" class="form-control border-0 shadow form-control-lg text-violet">
                    </div>
                    <div class="form-group mb-4">
                        <div class="custom-control custom-checkbox">
                            <input id="customCheck1" type="checkbox" checked class="custom-control-input">
                            <label for="customCheck1" class="custom-control-label">Remember Me</label>
                        </div>
                    </div>
                    <button type="button" class="btn btn-primary shadow px-5" onclick="login()">Log in</button>
                </form>
            </div>
        </div>
        <p class="mt-5 mb-0 text-gray-400 text-center">Copyright &copy; 2019.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">SISE</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">Springboot</a> & Your company</p>
    </div>
</div>
<!-- JavaScript files-->
<script src="${pageContext.request.contextPath}/static/adminlogin/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlogin/popper.min.js"> </script>
<script src="${pageContext.request.contextPath}/static/adminlogin/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlogin/jquery.cookie.js"> </script>
<script src="${pageContext.request.contextPath}/static/adminlogin/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlogin/js.cookie.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlogin/front.js"></script>

    <script type="text/javascript">
        function login() {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/adminlogin" ,//url
                data: $('#loginForm').serialize(),
                success: function (result) {
                    // alert(result);
                    if (result=="1"){
                       location.href="/HistogramWorkFirst"
                    } else {
                        alert("您输入的管理员账号密码有误！")
                    }

                    ;
                },
                error : function() {
                    alert("请输入账号密码！");
                }
            });
        }
    </script>

</body>
</html>