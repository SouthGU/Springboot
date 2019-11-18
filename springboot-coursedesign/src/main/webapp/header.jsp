<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/11/17
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation"
         style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">BOOT客户管理系统 v2.0</a>
        </div>
        <!-- /.navbar-header -->

        <%--    <ul class="nav navbar-top-links navbar-right">--%>
        <%--        <li class="dropdown"><a class="dropdown-toggle"--%>
        <%--                                data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i>--%>
        <%--            <i class="fa fa-caret-down"></i>--%>
        <%--        </a>--%>
        <%--            <ul class="dropdown-menu dropdown-messages">--%>
        <%--                <li><a href="#">--%>
        <%--                    <div>--%>
        <%--                        <strong>令狐冲</strong> <span class="pull-right text-muted">--%>
        <%--									<em>昨天</em>--%>
        <%--								</span>--%>
        <%--                    </div>--%>
        <%--                    <div>今天晚上向大哥找我吃饭，讨论一下去梅庄的事...</div>--%>
        <%--                </a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a class="text-center" href="#"> <strong>查看全部消息</strong>--%>
        <%--                    <i class="fa fa-angle-right"></i>--%>
        <%--                </a></li>--%>
        <%--            </ul> <!-- /.dropdown-messages --></li>--%>
        <%--        <!-- /.dropdown -->--%>
        <%--        <li class="dropdown"><a class="dropdown-toggle"--%>
        <%--                                data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>--%>
        <%--            <i class="fa fa-caret-down"></i>--%>
        <%--        </a>--%>
        <%--            <ul class="dropdown-menu dropdown-tasks">--%>
        <%--                <li><a href="#">--%>
        <%--                    <div>--%>
        <%--                        <p>--%>
        <%--                            <strong>任务 1</strong> <span class="pull-right text-muted">完成40%</span>--%>
        <%--                        </p>--%>
        <%--                        <div class="progress progress-striped active">--%>
        <%--                            <div class="progress-bar progress-bar-success"--%>
        <%--                                 role="progressbar" aria-valuenow="40" aria-valuemin="0"--%>
        <%--                                 aria-valuemax="100" style="width: 40%">--%>
        <%--                                <span class="sr-only">完成40%</span>--%>
        <%--                            </div>--%>
        <%--                        </div>--%>
        <%--                    </div>--%>
        <%--                </a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a href="#">--%>
        <%--                    <div>--%>
        <%--                        <p>--%>
        <%--                            <strong>任务 2</strong> <span class="pull-right text-muted">完成20%</span>--%>
        <%--                        </p>--%>
        <%--                        <div class="progress progress-striped active">--%>
        <%--                            <div class="progress-bar progress-bar-info" role="progressbar"--%>
        <%--                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"--%>
        <%--                                 style="width: 20%">--%>
        <%--                                <span class="sr-only">完成20%</span>--%>
        <%--                            </div>--%>
        <%--                        </div>--%>
        <%--                    </div>--%>
        <%--                </a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a class="text-center" href="#"> <strong>查看所有任务</strong>--%>
        <%--                    <i class="fa fa-angle-right"></i>--%>
        <%--                </a></li>--%>
        <%--            </ul> <!-- /.dropdown-tasks --></li>--%>
        <%--        <!-- /.dropdown -->--%>
        <%--        <li class="dropdown"><a class="dropdown-toggle"--%>
        <%--                                data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>--%>
        <%--            <i class="fa fa-caret-down"></i>--%>
        <%--        </a>--%>
        <%--            <ul class="dropdown-menu dropdown-alerts">--%>
        <%--                <li><a href="#">--%>
        <%--                    <div>--%>
        <%--                        <i class="fa fa-comment fa-fw"></i> 新回复 <span--%>
        <%--                            class="pull-right text-muted small">4分钟之前</span>--%>
        <%--                    </div>--%>
        <%--                </a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a href="#">--%>
        <%--                    <div>--%>
        <%--                        <i class="fa fa-envelope fa-fw"></i> 新消息 <span--%>
        <%--                            class="pull-right text-muted small">4分钟之前</span>--%>
        <%--                    </div>--%>
        <%--                </a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a href="#">--%>
        <%--                    <div>--%>
        <%--                        <i class="fa fa-tasks fa-fw"></i> 新任务 <span--%>
        <%--                            class="pull-right text-muted small">4分钟之前</span>--%>
        <%--                    </div>--%>
        <%--                </a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a href="#">--%>
        <%--                    <div>--%>
        <%--                        <i class="fa fa-upload fa-fw"></i> 服务器重启 <span--%>
        <%--                            class="pull-right text-muted small">4分钟之前</span>--%>
        <%--                    </div>--%>
        <%--                </a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a class="text-center" href="#"> <strong>查看所有提醒</strong>--%>
        <%--                    <i class="fa fa-angle-right"></i>--%>
        <%--                </a></li>--%>
        <%--            </ul> <!-- /.dropdown-alerts --></li>--%>
        <%--        <!-- /.dropdown -->--%>
        <%--        <li class="dropdown"><a class="dropdown-toggle"--%>
        <%--                                data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>--%>
        <%--            <i class="fa fa-caret-down"></i>--%>
        <%--        </a>--%>
        <%--            <ul class="dropdown-menu dropdown-user">--%>
        <%--                <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户设置</a></li>--%>
        <%--                <li><a href="#"><i class="fa fa-gear fa-fw"></i> 系统设置</a></li>--%>
        <%--                <li class="divider"></li>--%>
        <%--                <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>--%>
        <%--                    退出登录</a></li>--%>
        <%--            </ul> <!-- /.dropdown-user --></li>--%>
        <%--        <!-- /.dropdown -->--%>
        <%--    </ul>--%>
        <!-- /.navbar-top-links -->

    <jsp:include page="sidebar.jsp"/>
    <!-- /.navbar-static-side --> </nav>
</body>
</html>
