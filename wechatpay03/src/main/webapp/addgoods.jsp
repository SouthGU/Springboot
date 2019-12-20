<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/12/18
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<form action="/addgoods" method="post">
        <td>名称 ：</td><td><input type="text" name="title"></td><br><br>
        <td>价格 ：</td><td><input type="number" name="price">分</td><br><br>
        <input type="submit" name="button" value="添加商品">
</form>
</body>
</html>
