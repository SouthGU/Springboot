<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/12/18
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action="/api/v1/order/buy"--%>
<%--      method="post"--%>
<%--      enctype="application/x-www-form-urlencoded">--%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">课程名称</th>
            <th scope="col">价格</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${videoList}" var="v">
            <tr>
                <input type="hidden" name="video_id" value="${v.id}"/>
                <th scope="row">${v.id}</th>
                <td>${v.title}</td>
                <td>${v.price/100}元</td>
                <td><a href="/api/v1/order/buy?video_id=${v.id}">支付</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--</form>--%>

</body>
<script type="application/javascript">
    function myfunction(){
        // location.href="/api/v1/order/buy/"+;
    }
</script>
</html>
