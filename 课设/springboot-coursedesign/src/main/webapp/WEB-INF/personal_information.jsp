<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/17
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${sessionScope.standardWorkload}" var="standardWorkload" />
<c:set value="${sessionScope.number}" var="number" />
<c:set value="${sessionScope.pno}" var="pno" />
<html>
<head>
    <title>个人信息</title>
</head>
<body>
    <jsp:include page="source.jsp" />
    <!-- 签到模态对话框 -->
    <div class="modal fade" id="workDays" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">确认签到</h5>
                    <button class="close" type="button" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>你确定要签到吗？</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                    <a name="a">
                        <button class="btn btn-danger" type="button" onclick="test()">确认</button>
                    </a>

                </div>
            </div>
        </div>
    </div>
    <!-- 请假模态对话框 -->
    <div class="modal fade" id="leaveDays" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">确认请假</h5>
                    <button class="close" type="button" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>你确定要请假吗？</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                    <a name="a">
                        <button class="btn btn-danger" type="button" onclick="test()">确认</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- 加班模态对话框 -->
    <div class="modal fade" id="overtimeDays" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">确认加班</h5>
                    <button class="close" type="button" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>你确定要加班吗？</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                    <a name="a">
                        <button class="btn btn-danger" type="button" onclick="test()">确认</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- 确认标准工作量模态对话框 -->
    <div class="modal fade" id="standardWorkload" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">确认标准工作量</h5>
                    <button class="close" type="button" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>你确定要提交这个工作量<span id="workload"></span>吗？</p>
                    <p>提交后将不能修改</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
<%--                    <a id="standard">--%>
                        <button class="btn btn-danger" type="button" id="confirm">确认</button>
<%--                    </a>--%>
                </div>
            </div>
        </div>
    </div>
    <h4 class="mx-5 my-3">个人信息</h4>
    <table align="center" border="1" class="table table-bordered table-striped mx-5 my-3">
        <tr align="center">
            <th>快递员编号</th>
            <th>快递员账号名称</th>
            <th>收件量</th>
            <th>派件量</th>
            <th>快递员所属区域</th>
            <th>操作</th>
        </tr>
        <tr align="center">
            <c:forEach items="${sessionScope.postman}" var="postman">
                <td>${postman.id}</td>
                <td>${postman.postmanName}</td>
                <td>${postman.getGoodsTotal}</td>
                <td>${postman.outGoodsTotal}</td>
                <td>${postman.area}</td>
                <td>
<%--                    <a href="">--%>
<%--                        <button>修改个人信息</button>--%>
<%--                    </a>--%>
                    <button data-toggle="modal" data-target="#workDays" onclick="getId(this)">签到</button>
                    <button data-toggle="modal" data-target="#leaveDays" onclick="getId(this)">请假</button>
                    <button data-toggle="modal" data-target="#overtimeDays" onclick="getId(this)">加班</button>
                </td>
            </c:forEach>
        </tr>
    </table>
<%--    <table align="center" border="1">--%>
<%--        <tr align="center">--%>
<%--            <th>工作天数</th>--%>
<%--            <th>请假天数</th>--%>
<%--            <th>加班天数</th>--%>
<%--            <th>操作</th>--%>
<%--        </tr>--%>
<%--        <tr align="center">--%>
<%--            <c:forEach items="${sessionScope.postmanDays}" var="postmanDays">--%>
<%--                <td>${postmanDays.workDays}</td>--%>
<%--                <td>${postmanDays.leaveDays}</td>--%>
<%--                <td>${postmanDays.overtimeDays}</td>--%>
<%--                <td>--%>
<%--                </td>--%>
<%--            </c:forEach>--%>
<%--        </tr>--%>
<%--    </table>--%>
    <table align="center" border="1" class="table table-bordered table-striped mx-5 my-3">
        <tr align="center">
            <th>基本工资</th>
            <th>本月工作量</th>
            <th>工作量标准</th>
            <th>总工资</th>
            <th>操作</th>
        </tr>
        <tr align="center">
            <c:forEach items="${sessionScope.postman}" var="postman">
                <td>${postman.basicPay}</td>
                <td>${postman.getGoodsTotal + postman.outGoodsTotal}</td>
                <td>
                    <input type="text" id="text" maxlength="5" oninput = "value=value.replace(/[^\d]/g,'')"  placeholder="请合情合理填写数字" >
                </td>
                <td>${postman.salary}</td>
                <td>
                    <button data-toggle="modal" data-target="#standardWorkload" id="standardWorkloadButton" class="btn btn-info btn-xs" onclick="getStandardWorkload()">提交自定义工作量标准</button>
                </td>
            </c:forEach>
        </tr>
    </table>

    <script type="text/javascript">
        function getId(element) {
            var action = new Array();
            action[0] = "updateWorkDays";
            action[1] = "updateLeaveDays";
            action[2] = "updateOvertimeDays";
            for (i = 0; i < 3; i++) {
                var node = element.parentNode.parentNode;
                var pno = node.children[0].innerHTML;
                var address = "/" + action[i] + "?pno=" + pno;
                document.getElementsByName("a")[i].setAttribute("href", address);
            }
        }
        function test() {
            if (${number == 10}){
                alert("成功");
            }
            if (${number == 11}){
                alert("失败");
            }
        }

        function getStandardWorkload() {
            var standardWorkload = document.getElementById("text").value;
            if(standardWorkload == 0){
                alert("标准工作量不能为空");
                window.location.reload();
            }
            else {
                document.getElementById("workload").innerHTML = standardWorkload;
                var address = "/findLastMonthWorkload?pno=" + ${pno} + "&&standardWorkload=" + standardWorkload;
                // document.getElementById("standard").setAttribute("href", address);
                $(document).ready(function(){
                    $("#confirm").click(function(){
                        $.ajax({url: address , success:function(result){
                                if (result == 1){
                                    alert("提交成功");
                                }
                                else if (result == 0){
                                    alert("工作量不合理");
                                }
                                else {
                                    alert("提交失败");
                                }
                                window.location.reload();
                            }});
                    });
                });
            }
        }

        if (${standardWorkload != 0}){
            var text = document.getElementById("text");
            $("#text").val(${standardWorkload});
            text.setAttribute("disabled", "true");
            document.getElementById("standardWorkloadButton").setAttribute("disabled", "true");
        }

        // $(document).ready(function(){
        //
        //     $('#standardWorkload').on('show.bs.modal', function(event){
        //         var button = $(event.relatedTarget);
        //         var cname = button.closest('tr').children('td').last().text();
        //         // var cid = button.data('cid');
        //
        //         $(this).find('#workload').text(cname);
        //         // $(this).find('#delete').data('cid', cid);
        //     })
        // });

        // $(document).ready(function(){
        //     $('#workDays').on('show.bs.modal', function(event){
        //         var button = $(event.relatedTarget);
        //         var cname = button.closest('tr').children('td').first().text();
        //         var cid = button.data('cid');
        //
        //         $(this).find('#course').text(cname);
        //         $(this).find('#delete').data('cid', cid)
        //     });
        // })
    </script>

</body>
</html>
