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
    <script src="xgl/js/echarts.min.js"></script>
    <link href="xgl/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="xgl/css/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="xgl/css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="xgl/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="xgl/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="xgl/css/boot-crm.css" rel="stylesheet"
          type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div id="wrapper">
    <!-- Navigation -->
    <jsp:include page="header.jsp"/>
    <!-- Navigation -->

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">派件管理系统</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">派件信息列表</div>
                    <!-- /.panel-heading -->
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th width="10%">快递编号</th>
                            <th width="10%">派件快递状态</th>
                            <th width="15%">收件快递员</th>
                            <th >派件失败原因</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${outpage.getContent()}" var="row">
                            <tr>
                                <td scope="row" style="text-align:center">${row.getId()}</td>
                                <td scope="row" style="text-align:center">${row.getOutGoodsStatus()}</td>
                                <td scope="row" style="text-align:center">${row.getPostman().getPostmanName()}</td>
                                <td scope="row" style="text-align:center">${row.getFailOutGoodsReason()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <div class="col-md-12 text-right">
<%--                        <c:page url="${pageContext.request.contextPath }/customer/list.action" />--%>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/QueryOutPost?page=${outpage.getNumber()-1>1?outpage.getNumber()-1:1}&size=10" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="/QueryOutPost?page=1&size=10">首页</a></li>



            <!-- 1-10页码展示 -->
            <!-- 如果总页数大于10页 -->
            <c:if test="${outpage.getTotalPages()>10}">
                <!-- 如果当前页面大于等于（1）&&小于等于（6） -->
                <c:if test="${(outpage.getNumber()>=0)&&(outpage.getNumber()<=6 )}">
                    <c:forEach begin="1" end="10" var="n">
                        <li class="page-item"><a class="page-link" href="/QueryOutPost?page=${n}&size=10">${n}</a></li>
                    </c:forEach>
                </c:if>
                <!-- 如果当前数大于等于（总页数-4）&&小于等于（总页数） -->
                <c:if test="${(outpage.getNumber()>=(outpage.getTotalPages()-4))&&(outpage.getNumber()<=outpage.getTotalPages()) }">
                    <c:forEach begin="${ outpage.getTotalPages()-9}" end="${outpage.getTotalPages() }" var="n">
                        <li class="page-item"><a class="page-link" href="/QueryOutPost?page=${n}&size=10">${n}</a></li>
                    </c:forEach>
                </c:if>
                <!-- 如果当前数大于（6）&&小于总页数-4） -->
                <c:if test="${(outpage.getNumber()>6)&&(outpage.getNumber()<(outpage.getTotalPages()-4))}">
                    <c:forEach begin="${ outpage.getNumber()-5}" end="${outpage.getNumber()+4 }" var="n">
                        <li class="page-item"><a class="page-link" href="/QueryOutPost?page=${n}&size=10">${n}</a></li>
                    </c:forEach>
                </c:if>
            </c:if>

            <!-- 如果总页数小于10页 -->
            <c:if test="${outpage.getTotalPages()<=10 }">
                <c:forEach begin="1" end="${outpage.getTotalPages() }" var="n">
<%--                    <a href="/QueryOutPost?page=${n}&size=10">${n}</a>--%>
                    <li class="page-item"><a class="page-link" href="/QueryOutPost?page=${n}&size=10">${n}</a></li>
                </c:forEach>
            </c:if>









<%--            <c:forEach begin="1" end="${outpage.getTotalPages()}" var="pageNum">--%>
<%--                <li class="page-item"><a class="page-link" href="/QueryOutPost?page=${pageNum}&size=10">${pageNum}</a></li>--%>
<%--            </c:forEach>--%>
<%--            --%>






            <li class="page-item"><a class="page-link" href="/QueryOutPost?page=${outpage.getTotalPages()}&size=10">末页</a></li>
            <li class="page-item">
                <a class="page-link" href="/QueryOutPost?page=${outpage.getNumber()+2>outpage.getTotalPages()?outpage.getTotalPages():outpage.getNumber()+2}&size=10" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="xgl/js/jquery.min.js"></script>
<script src="xgl/js/bootstrap.min.js"></script>
<script src="xgl/js/metisMenu.min.js"></script>
<script src="xgl/js/jquery.dataTables.min.js"></script>
<script src="xgl/js/dataTables.bootstrap.min.js"></script>
<script src="xgl/js/sb-admin-2.js"></script>

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

</body>

</html>

