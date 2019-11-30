package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.server.QueryMap2Service;
import com.sise.springbootcoursedesign.server.QueryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
     * @param startdate   起始时间
     * @param finallydate 终止时间
     * @param area        所属区域
     * @return http://localhost:8080/HistogramWork?startdate=2019-11-16&finallydate=2019-11-17&area=太平
     */
    @RequestMapping("/HistogramWork")
    public String HistogramWork(String startdate, String finallydate, String area, HttpServletRequest session) throws Exception {
        List<Integer> histogramWork_sum = queryMapService.HistogramWork(startdate, finallydate, area);

        List<String> areaArray = queryMapService.areaArray();
        session.setAttribute("histogramWork_sum", histogramWork_sum);
        session.setAttribute("areaArray", areaArray);

        List<String> HistogramWork_date = new ArrayList<>();
        HistogramWork_date.add(startdate);
        HistogramWork_date.add(finallydate);
        HistogramWork_date.add(area);

        session.setAttribute("histogramWork_sum", histogramWork_sum);
        session.setAttribute("areaArray", areaArray);
        session.setAttribute("HistogramWork_date", HistogramWork_date);

        return "Workload";
    }

    @RequestMapping("/HistogramWorkFirst")
    public String HistogramWork1(HttpServletRequest session) {
        List<String> areaArray = queryMapService.areaArray();
        session.setAttribute("areaArray", areaArray);
        return "Workload";
    }

    /**
     * @param startdate   起始时间
     * @param finallydate 终止时间
     * @param
     * @return http://localhost:8080/HistogramWork?startdate=2019-10-31&finallydate=2019-11-06&postmanid=1
     */
    @RequestMapping("/WorkDays")
    public String CircleWork(String startdate, String finallydate, String postmanid, HttpServletRequest session) throws Exception {
        int id = Integer.parseInt(postmanid);
        List<Integer> Postman_list = queryMap2Service.CircleWork(startdate, finallydate, id);

        List<String> CircleWork_date = new ArrayList<>();
        CircleWork_date.add(startdate);
        CircleWork_date.add(finallydate);
        CircleWork_date.add(postmanid);

        session.setAttribute("Postman_list", Postman_list);
        session.setAttribute("CircleWork_date", CircleWork_date);

        return "WorkDays";
    }

    @RequestMapping("/WorkDaysFirst")
    public String CircleWork1() {
        return "WorkDays";
    }


    @RequestMapping("/WorkDaysQueryPostmanById")
    @ResponseBody
    public String WorkDaysQueryPostmanById(String postmanid) {
        System.out.println(postmanid);
        int id =Integer.parseInt(postmanid);
        int i = queryMap2Service.WorkDaysQueryPostmanById(id);
        if (i>=1){
            return "1";
        }else {
            return "0";
        }

    }




}
