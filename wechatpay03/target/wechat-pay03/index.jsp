<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/12/18
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/api/v1/order/addgoods" method="post">
    <%--    ${sessionScope.name}--%>
    <td>名称 ：</td><td><input type="text" name="title1"></td>
    <td>价格 ：</td><td><input type="text" name="price"></td>
    <input type="submit" name="button" value="提交">
</form>
</body>
</html>
