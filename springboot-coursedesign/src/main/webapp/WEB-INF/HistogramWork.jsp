
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="${pageContext.request.contextPath}/static/xgl/js/echarts.js"></script>

</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:350px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '收派件工作量'
        },
        tooltip: {},
        legend: {
            data:['收派件工作量']
        },
        xAxis: {
            data: ["收派件计件数","最大工作量","最小工作量"]
        },
        yAxis: {},
        series: [{
            name: '工作量',
            type: 'bar',
            data: [${histogramWork_sum.get(0)}, ${histogramWork_sum.get(1)}, ${histogramWork_sum.get(2)}]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
