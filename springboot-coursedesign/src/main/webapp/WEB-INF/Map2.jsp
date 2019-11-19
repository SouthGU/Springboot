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
                    <input class="form-control" size="16"  name="startdate" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <input type="hidden" id="dtp_input22" value="" /><br/>

                <label for="dtp_input2" class="col-md-1 control-label">起始时间</label>
                <div class="input-group date form_date col-md-3" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input class="form-control" size="16"  name="finallydate"  type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
        </fieldset>
    </form>
    快递员编号：<input id="postmanid" name="postmanid" type="text"/>
    <button type="submit" class="btn btn-primary">查询</button>
    <br>
    <br>
    <jsp:include page="CircleWork.jsp"/>
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

