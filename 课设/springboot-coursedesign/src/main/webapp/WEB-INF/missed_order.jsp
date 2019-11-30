<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/15
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${sessionScope.area}" var="area" />
<c:set value="${sessionScope.num}" var="num" />
<c:set value="${sessionScope.pno}" var="pno" />
<html>
<head>
    <title>未接单</title>
</head>
<body>
    <jsp:include page="source.jsp" />
    <% int i = 0; %>
<%--    <form action="/updateOrderStatus" method="post">--%>
    <h4 class="mx-5 my-3">未接单快递</h4>
        <table align="center" border="1" class="table table-bordered table-striped mx-5 my-3">
            <tr align="center">
                <th>序号</th>
                <th>快递编号</th>
                <th>目标地址</th>
                <th>电话</th>
                <th>收件时间</th>
                <th>剩余派送次数</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.sort}" var="post">
                <c:if test="${post.outGoodsFault eq '否' && post.orderStatus eq '否'}">
                    <% i++; %>
                    <tr align="center">
                        <td><%=i%></td>
                        <td>${post.id}</td>
                        <td>${post.targetAddress}</td>
                        <td>${post.phone}</td>
                        <td>${post.getDate}</td>
                        <td id="outGoodsNumber">${post.outGoodsNumber}</td>
                        <td>
<%--                            <input type="submit" value="接单">--%>
                            <a href="/updateOrderStatus?eno=${post.id}&&pno=${pno}&&area=${area}">
                                <button id="orderStatus" class="btn btn-primary btn-xs" onclick="test()">接单</button>
                            </a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
<%--    </form>--%>

    <script type="text/javascript">
        function test() {
            if (${num == 20}){
                alert("接单成功");
            }
            if (${num == 21}){
                alert("接单失败,已被接单");
            }
        }
        // $(document).ready(function(){
        //     $("#orderStatus").click(function(){
        //         $.ajax({url: address , success:function(result){
        //                 if (result == 1){
        //                     alert("提交成功");
        //                 }
        //                 else if (result == 0){
        //                     alert("工作量不合理");
        //                 }
        //                 else {
        //                     alert("提交失败");
        //                 }
        //                 window.location.reload();
        //             }});
        //     });
        // });
    </script>

</body>
</html>
