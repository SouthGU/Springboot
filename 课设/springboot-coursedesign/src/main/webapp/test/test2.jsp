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
    <!-- Bootstrap Core CSS -->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/static/css/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="${pageContext.request.contextPath}/static/css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/boot-crm.css" rel="stylesheet"
          type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<script>
    $(document).ready(function(){
        $("button").click(function(){
            // $.ajax({
            //     url: "HistogramWork.jsp",
            //     type:"GET",
            //     success:function (data) {
            //         var result = $(data).find()
            //     }
            // })
            $("#div1").load("test2.jsp");//把他当做一个请求了
        });
    });
</script>
<body>
<div id="div1"><h2>使用 jQuery AJAX 修改文本内容</h2></div>
<button>获取外部内容</button>
<div id="wrapper">
    <!-- Navigation -->
    <jsp:include page="header.jsp"/>
    <!-- Navigation -->

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">显示头部文字</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="panel panel-default">
            <div class="panel-body">
                <form class="form-inline" action="/test2" method="get">
                    <div class="form-group">
                        <label for="customerName">客户名称</label>
                        <input type="text" class="form-control" id="customerName" value="${vo.custName }" name="custName">
                    </div>
                    <div class="form-group">
                        <label for="customerFrom">客户来源</label>
                        <select	class="form-control" id="customerFrom" placeholder="客户来源" name="custSource">
                            <option value="">--www--</option>
                            <option value="">sss</option>
                            <option value="">www</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="custIndustry">所属行业</label>
                        <select	class="form-control" id="custIndustry"  name="custIndustry">
                            <option value="">--所属行业--</option>
                            <option value="">sss</option>
                            <option value="">www</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="custLevel">客户级别</label>
                        <select	class="form-control" id="custLevel" name="custLevel">
                            <option value="">--客户级别--</option>

                                <option value="">sss</option>
                            <option value="">www</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">查询</button>
                </form>
            </div>
        </div>
        <div class="row">
            <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
            <div id="main" style="width: 600px;height:400px;"></div>
        </div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/sb-admin-2.js"></script>

<script type="text/javascript">
    function editCustomer(id) {
        $.ajax({
            type:"get",
            url:"<%=basePath%>customer/edit.action",
            data:{"id":id},
            success:function(data) {
                $("#edit_cust_id").val(data.cust_id);
                $("#edit_customerName").val(data.cust_name);
                $("#edit_customerFrom").val(data.cust_source)
                $("#edit_custIndustry").val(data.cust_industry)
                $("#edit_custLevel").val(data.cust_level)
                $("#edit_linkMan").val(data.cust_linkman);
                $("#edit_phone").val(data.cust_phone);
                $("#edit_mobile").val(data.cust_mobile);
                $("#edit_zipcode").val(data.cust_zipcode);
                $("#edit_address").val(data.cust_address);

            }
        });
    }
    function updateCustomer() {
        alert($("#edit_customer_form").serialize());
        $.post("<%=basePath%>customer/update.action",$("#edit_customer_form").serialize(),function(data){
            if(data == "0"){
                alert("客户信息更新成功！");
            }else{
                alert("客户信息更新失败！");
            }
            window.location.reload();
        });
    }

    function deleteCustomer(id) {
        if(confirm('确实要删除该客户吗?')) {
            $.post("<%=basePath%>customer/delete.action",{"id":id},function(data){
                if(data == "0"){
                    alert("客户信息删除成功！");
                }else{
                    alert("客户信息删除失败！");
                }
                window.location.reload();
            });
        }
    }
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [${sessionScope.test3.basicPay}, ${sessionScope.test3.basicPay}, ${sessionScope.test3.basicPay}, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>

</html>

