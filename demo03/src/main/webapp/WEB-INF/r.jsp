<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/9/18
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
学号：${sessionScope.user.uid}<br/>
学生名：${sessionScope.user.username}<br/>
密码：${sessionScope.user.password}
</body>
</html>
