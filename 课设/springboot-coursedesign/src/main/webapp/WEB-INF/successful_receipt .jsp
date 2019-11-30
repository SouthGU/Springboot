<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/15
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${sessionScope.area}" var="area" />
<c:set value="${sessionScope.pno}" var="pno" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% int i = 0; %>
    <jsp:include page="source.jsp" />
    <div class="modal fade" id="modal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">填写失败原因</h5>
                    <button class="close" type="button" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
<%--                <form action="/updateOutGoodsNumber" method="post">--%>
<%--                    <input type="hidden" id="id" name="id">--%>
<%--                    <input type="hidden" id="hidden" name="hidden">--%>
                    <div class="modal-body">
                        <input type="text" id="text" name="text">
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                        <a id="a">
                            <button class="btn btn-danger" type="button" name="button" onclick="getText()">确认</button>
                        </a>
                    </div>
<%--                </form>--%>
            </div>
        </div>
    </div>
<%--    <form action="/updateStartDispatching" method="post">--%>
    <h4 class="mx-5 my-3">成功收件快递</h4>
        <table align="center" border="1" id="table" class="table table-bordered table-striped mx-5 my-3">
            <tr align="center">
                <th>序号</th>
                <th>快递编号</th>
                <th>目标地址</th>
                <th>电话</th>
                <th>收件时间</th>
                <th>派件时间</th>
                <th>剩余派送次数</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.post}" var="post">
                <c:if test="${post.outGoodsFault eq '否' && post.orderStatus eq '是' && post.getGoodsStatus eq '收件成功'}">
<%--                    <input name="id" type="hidden" value="${post.id}">--%>
                    <% i++; %>
                    <tr align="center">
                        <td><%=i%></td>
                        <td id="id">${post.id}</td>
                        <td>${post.targetAddress}</td>
                        <td>${post.phone}</td>
                        <td>${post.getDate}</td>
                        <td>${post.outDate}</td>
                        <td>${post.outGoodsNumber}</td>
                        <td>
<%--                            <input type="submit" value="开始派件">--%>
                            <c:choose>
                                <c:when test="${post.outGoodsStatus eq '正在派件'}">
<%--                                    <a href="/updateOutGoodsNumber?id=${post.id}">--%>
                                        <button data-toggle="modal" data-target="#modal" class="btn btn-danger btn-xs" onclick="getId(this)">派件失败</button>
<%--                                    </a>--%>
                                </c:when>
                                <c:otherwise>
                                    <a href="/updateStartDispatching?eno=${post.id}&&pno=${pno}">
                                        <button class="btn btn-primary btn-xs">开始派件</button>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
<%--   </form>--%>

    <script type="text/javascript">
        // function controller(){
        //     var text = $("#text").value();
        //     $("#hidden").val(text);
        // }
        var eno;
        function getId(element) {
            //this做为参数传过来是方法中的element,parentNode就是获取父节点，获取了连个父节点，就相当于获取了tr
            var node = element.parentNode.parentNode;
            eno = node.children[1].innerHTML;
            // var id = $("td[name='model']").attr("id");
            // id = document.getElementsByName("model")[0].getAttribute("id");
            // id = $(this).parents("tr").find(".id").val();
            // var number = parseInt(document.getElementById("table").rows[id].cells[0].innerText);
            //$("#id").val(number);
        }
        function getText() {
            var text = document.getElementById("text").value;
            var address = "/updateOutGoodsNumber?eno=" + eno + "&&pno=" + ${pno} + "&&text=" + text + "&&area=${area}";
            document.getElementById("a").setAttribute("href", address);
        }
    </script>

</body>
</html>
