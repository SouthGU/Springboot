<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/11/18
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/static/css1/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/static/css1/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>
<div class="container">
    <form action="" class="form-horizontal"  role="form">
        <fieldset>
            <div class="form-group">
                <label for="dtp_input2" class="col-md-1 control-label">起始时间</label>
                <div class="input-group date form_date col-md-3" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="16" id="ipt1"  name="startdate" type="text" value="${HistogramWork_date.get(0)}" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <input type="hidden" id="dtp_input22" value="" /><br/>

                <label for="dtp_input2" class="col-md-1 control-label">终止时间</label>
                <div class="input-group date form_date col-md-3" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="16"  id="ipt2" name="finallydate"  type="text" value="${HistogramWork_date.get(1)}" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
        </fieldset>
    </form>
    <label >区域  :  </label>
    <select	class="form-group-lg"  id="area" name="area">
        <c:forEach items="${areaArray}" var="i">
        <option value="${i}"
                <c:if test="${i == HistogramWork_date.get(2)}"> selected</c:if>
        >
                ${i}</option>
        </c:forEach>
<%--        <option value="太平">太平</option>--%>
<%--        <option value="良口">良口</option>--%>
    </select>
    <button type="submit" class="btn btn-primary" onclick="checkform()">查询</button>
    <br>
    <br>
    <jsp:include page="HistogramWork.jsp"/>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js1/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js1/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js1/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script  src="${pageContext.request.contextPath}/static/js1/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">

    $('.form_date').datetimepicker({
        language:'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    // $(document).ready(function(){
    //     $("button").click(function(){
    //         alert("ֵ查询的结果: " + $("input[name='finallydate']").val());
    //     });
    // });

</script>


</body>
</html>

