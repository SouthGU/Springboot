package com.sise.springbootcoursedesign.controller;
import com.sise.springbootcoursedesign.server.QueryMap2Service;
import com.sise.springbootcoursedesign.server.QueryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/18/19:05
 * @Description:
 */
@Controller
public class QueryMap {

    @Autowired
    QueryMapService queryMapService;

    @Autowired
    QueryMap2Service queryMap2Service;
    /**
     * @param startdate 起始时间
     * @param finallydate 终止时间
     * @param area 所属区域
     * @return
     * http://localhost:8080/HistogramWork?startdate=2019-11-16&finallydate=2019-11-17&area=太平
     */
    @RequestMapping("/HistogramWork")
    public String HistogramWork(String startdate,String finallydate,String area,HttpSession session) throws Exception {
        List<Integer> histogramWork_sum = queryMapService.HistogramWork(startdate, finallydate, area);
        System.out.println("Controller:------"+histogramWork_sum);
        session.setAttribute("histogramWork_sum",histogramWork_sum);
        return "Workload";
    }

    @RequestMapping("/HistogramWorkFirst")
    public String HistogramWork1() throws Exception {
        return "Workload";
    }


    /**
     * @param startdate 起始时间
     * @param finallydate 终止时间
     * @param
     * @return
     * http://localhost:8080/HistogramWork?startdate=2019-10-31&finallydate=2019-11-06&postmanid=1
     */
    @RequestMapping("/WorkDays")
    public String CircleWork(String startdate,String finallydate,String postmanid,HttpSession session) throws Exception {
        int id = Integer.parseInt(postmanid);
        List<Integer> Postman_list = queryMap2Service.CircleWork(startdate, finallydate, id);
        System.out.println(Postman_list);
        session.setAttribute("Postman_list",Postman_list);
        return "WorkDays";
    }

    @RequestMapping("/WorkDaysFirst")
    public String CircleWork1() {
        return "WorkDays";
    }

}
