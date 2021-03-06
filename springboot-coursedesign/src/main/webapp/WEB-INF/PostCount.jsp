<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>客户列表-BootCRM</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/xgl/js/echarts.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/xgl/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/xgl/css/metisMenu.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/xgl/css/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/xgl/css/sb-admin-2.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/xgl/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="${pageContext.request.contextPath}/xgl/static/css/boot-crm.css" rel="stylesheet"  type="text/css">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div id="wrapper">
    <jsp:include page="header.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h4 class="page-header">
                    统计：按月或天分别统计RSC系统邮件发件量、收件量及故障件数
                </h4>
            </div>
        </div>
        <div class="panel panel-default">
<br>
            <jsp:include page="Map3.jsp"/>
        </div>
        <div class="row">


        </div>
    </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/xgl/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/xgl/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/xgl/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/static/xgl/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/xgl/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/xgl/js/sb-admin-2.js"></script>

<script type="text/javascript">
    // $(document).ready(function(){
    //     $("button").click(function(){
    //         // alert("ֵ查询的结果: " + $("input[name='finallydate']").val());
    //         location.href="/PostCount?startdate="+$("input[name='startdate']").val()+
    //             "&finallydate="+$("input[name='finallydate']").val();
    //     });
    // });


    function checkform() {
        if (document.getElementById('ipt1').value.length !== 0) {
            if (document.getElementById('ipt2').value.length !== 0) {
                location.href="/PostCount?startdate="+$("input[name='startdate']").val()+
                "&finallydate="+$("input[name='finallydate']").val();
            } else {
                alert('结束时间的输入值为空，请重新输入！');
                return false;
            }
        } else {
            alert('开始时间的输入值为空，请重新输入！');
            return false;
        }
    }
</script>
</body>

</html>

