<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/16
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${sessionScope.area}" var="area" />
<c:set value="${sessionScope.pno}" var="pno" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="source.jsp" />
    <div class="main-container" style="height: 100%">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">订单管理</li>

                    <li class="nav-item nav-dropdown">
                        <a href="/findPersonalInformation?pno=1" class="nav-link">
                            <i class="icon icon-target"></i>
                            个人信息
                            <i class="fa fa-caret-left"></i>
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i>
                            快递信息
                            <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/findMissOrder?pno=${pno}" class="nav-link">
                                    未接单
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="/findUndeliveredExpress?pno=${pno}" class="nav-link">
                                    未收件成功
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="/findSuccessfulReceipt?pno=${pno}" class="nav-link" onclick="">
                                    收件成功
                                </a>
                            </li>

<%--                            <li class="nav-item">--%>
<%--                                <a href="/findDeliveryOrder" class="nav-link">--%>
<%--                                    派件中--%>
<%--                                </a>--%>
<%--                            </li>--%>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
<%--    <form action="" method="POST"></form>--%>

    <script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<%--    <script type="text/javascript">--%>
<%--        $(function () {--%>
<%--            //为所有的class为delete的按钮点击动作添加行为函数--%>
<%--            $(".nav-item").click(function () {--%>
<%--                //获取class为delete的超链接的地址--%>
<%--                var href = $(this).attr("href");--%>
<%--                //为隐藏域的action赋值并提交--%>
<%--                $("form").attr("action", href).submit();--%>
<%--                return false;--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>

</body>
</html>
