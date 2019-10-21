<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/10/16
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-bordered" style="font-family: 'Adobe Arabic'">
    <tr>
    <th>EID</th>
        <th>EName</th>
        <th>Eage</th>
    </tr>

    <c:forEach items="${sessionScope.employees}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>

    </c:forEach>
</table>


</body>
</html>
