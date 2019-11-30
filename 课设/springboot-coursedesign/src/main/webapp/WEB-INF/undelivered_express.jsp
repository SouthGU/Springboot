<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/21
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${sessionScope.pno}" var="pno" />
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
    <jsp:include page="source.jsp" />
    <% int i = 0; %>
    <div class="modal fade" id="getGoods" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">填写失败原因</h5>
                    <button class="close" type="button" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="text" id="text" name="text">
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                    <a id="b">
                        <button class="btn btn-danger" type="button" name="button" onclick="getText()">确认</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <h4 class="mx-5 my-3">未收件快递</h4>
    <table align="center" border="1" class="table table-bordered table-striped mx-5 my-3">
        <tr align="center">
            <th>序号</th>
            <th>快递编号</th>
            <th>目标地址</th>
            <th>电话</th>
            <th>是否已接单</th>
            <th>收件状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sessionScope.post}" var="post">
            <c:if test="${post.outGoodsFault eq '否' && post.orderStatus eq '是' && post.getGoodsStatus eq '准备收件' && post.getGoodsFault eq '否'}">
                <% i++; %>
                <tr align="center">
                    <td><%=i%></td>
                    <td>${post.id}</td>
                    <td>${post.targetAddress}</td>
                    <td>${post.phone}</td>
                    <td>${post.orderStatus}</td>
                    <td>${post.getGoodsStatus}</td>
                    <td>
                        <button data-toggle="modal" data-target="#getGoods" class="btn btn-danger btn-xs" onclick="getId(this)">收件失败</button>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>

    <script src="js/jquery-3.4.0.js"></script>
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript">
        var eno;
        function getId(element) {
            var node = element.parentNode.parentNode;
            eno = node.children[1].innerHTML;
        }

        function getText() {
            var text = document.getElementById("text").value;
            var address = "/updateGetGoods?eno=" + eno + "&&pno=" + ${pno} + "&&text=" + text;
            document.getElementById("b").setAttribute("href", address);
        }
    </script>

</body>
</html>
