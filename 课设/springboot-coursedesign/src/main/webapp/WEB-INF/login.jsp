<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/21
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${sessionScope.value}" var="value" />
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="wxy/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row my-5">
        <div class="col-4"></div>
        <div class="col-4">
            <h5 class="text-center">登录</h5>
            <form action="/validateLogon" method="post" onSubmit="return validate(this)">
                <div class="form-group">
                    <label for="pno">编号</label>
                    <input class="form-control" type="text" name="pno" id="pno">
                </div>
                <div class="form-group">
                    <label for="pwd">密码</label>
                    <input class="form-control" type="password" name="password" id="pwd">
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit" onclick="te()" id="login">登录</button>
                </div>
                <div class="form-group">
                    <button class="btn btn-secondary btn-block" type="button">重置</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="wxy/js/jquery-3.4.0.js"></script>
<script src="wxy/js/bootstrap.js"></script>
<script type="wxy/text/javascript">

    function validate(form) {
        if(form.pno.value == "" && form.password.value == ""){
            alert('编号、密码不能为空！');
            return false;
        }
        else if (form.pno.value == ""){
            alert('编号不能为空！');
            return false;
        }
        else if (form.password.value == ""){
            alert('密码不能为空！');
            return false;
        }
        else {
            return true;
        }
    }
    function te() {
        if (${value == 0}){
            alert("密码错误");
        }
        else if(${value == 1}){
            alert("编号不存在");
        }
    }
    // $(document).ready(function(){
    //     $("#login").click(function(){
    //         $.ajax({url: "/validateLogon" , success:function(result){
    //                 if (result == 1){
    //                     alert("编号b");
    //                 }
    //                 else if (result == 0){
    //                     alert("密码错误");
    //                 }
    //                 else {
    //                     alert("提交失败");
    //                 }
    //                 window.location.reload();
    //             }});
    //     });
    // });
</script>

<script src="js/jquery-3.4.0.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
