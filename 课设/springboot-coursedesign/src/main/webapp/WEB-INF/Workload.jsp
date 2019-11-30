<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>快递系统</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="xgl/js/echarts.min.js"></script>
    <link href="xgl/css/bootstrap.min.css" rel="stylesheet">
    <link href="xgl/css/metisMenu.min.css" rel="stylesheet">
    <link href="xgl/css/dataTables.bootstrap.css" rel="stylesheet">
    <link href="xgl/css/sb-admin-2.css" rel="stylesheet">
    <link href="xgl/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="xgl/css/boot-crm.css" rel="stylesheet" type="text/css">
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
                <h4 class="page-header">查询某月按区域地址所有邮差（邮递员）的工作量（收派件计件数），最大工作量和最小工作量</h4>
                <%--                <button>发送</button>--%>
            </div>
        </div>
        <div class="panel panel-default">
            <br>
            <jsp:include page="Map1.jsp"/>
        </div>
        <div class="row">


        </div>
    </div>
</div>
<!-- jQuery -->
<script src="xgl/js/jquery.min.js"></script>
<script src="xgl/js/bootstrap.min.js"></script>
<script src="xgl/js/metisMenu.min.js"></script>
<script src="xgl/js/jquery.dataTables.min.js"></script>
<script src="xgl/js/dataTables.bootstrap.min.js"></script>
<script src="xgl/js/sb-admin-2.js"></script>

<script type="text/javascript">

    function checkform() {
        if (document.getElementById('ipt1').value.length !== 0) {
            if (document.getElementById('ipt2').value.length !== 0) {
                location.href = "/HistogramWork?startdate=" + $("input[name='startdate']").val() +
                    "&finallydate=" + $("input[name='finallydate']").val() + "&area=" + $("#area").val();
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

