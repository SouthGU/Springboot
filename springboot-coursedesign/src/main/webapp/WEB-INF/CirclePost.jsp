<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/11/19
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="${pageContext.request.contextPath}/static/xgl/js/echarts.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main1" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));

    // 指定图表的配置项和数据
    var option = {
        title : {
            text: '邮件统计图',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['发件量 : ${post_list.get(0)} 件','收件量 : ${post_list.get(1)} 件','故障件数 : ${post_list.get(2)} 件']
        },
        series : [
            {
                name: '快递',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:${post_list.get(0)}, name:'发件量 : ${post_list.get(0)} 件'},
                    {value:${post_list.get(1)}, name:'收件量 : ${post_list.get(1)} 件'},
                    {value:${post_list.get(2)}, name:'故障件数 : ${post_list.get(2)} 件'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
</html>
