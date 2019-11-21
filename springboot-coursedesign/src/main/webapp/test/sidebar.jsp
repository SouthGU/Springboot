<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/11/17
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="查询内容...">
                    <span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="fa fa-search" style="padding: 3px 0 3px 0;"></i>
								</button>
							</span>
                </div> <!-- /input-group -->
            </li>
            <li><a href="customer.action" class="active"><i
                    class="fa fa-edit fa-fw"></i> 客户管理</a></li>
            <li><a href="salevisit.action"><i
                    class="fa fa-dashboard fa-fw"></i> 客户拜访</a></li>
            <li><a href="salevisit.action"><i
                    class="fa fa-dashboard fa-fw"></i> test</a></li>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>
</body>
</html>
