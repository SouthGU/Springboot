<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/9/18
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
排序！！！
<br/>
<table class="table table-bordered" style="font-family: 宋体">
    <tr>
        <th style="text-align: center">uid</th>
        <th style="text-align: center">username</th>
        <th style="text-align: center">password</th>
    </tr>
<c:forEach items="${sessionScope.sort}" var="user">
<tr>
    <td>${user.uid}</td>
    <td>${user.username}</td>
    <td>${user.password}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
