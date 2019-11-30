<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/16
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${sessionScope.code}" var="code" />
<html>
<head>
    <title>首页</title>
</head>
<body>
    <jsp:include page="source.jsp" />
    <div>
        <div>
            <div style="float: left">
                <jsp:include page="navigation.jsp" />
            </div>
            <div style="float: left">
                <c:if test="${code == 0}">
                    <jsp:include page="personal_information.jsp" />
                </c:if>
                <c:if test="${code == 1}">
                    <jsp:include page="missed_order.jsp" />
                </c:if>
                <c:if test="${code == 2}">
                    <jsp:include page="successful_receipt .jsp" />
                </c:if>
                <c:if test="${code == 3}">
                    <jsp:include page="undelivered_express.jsp" />
                </c:if>
            </div>
        </div>
    </div>

</body>
</html>