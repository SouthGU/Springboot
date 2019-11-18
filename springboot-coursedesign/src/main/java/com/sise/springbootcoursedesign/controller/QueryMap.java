package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.server.QueryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/18/19:05
 * @Description:
 */
@Controller
public class QueryMap {

    @Autowired
    QueryMapService queryMapService;

    /**
     * @param startdate 起始时间
     * @param finallydate 终止时间
     * @param area 所属区域
     * @return
     * http://localhost:8080/HistogramWork?startdate=2019-11-16&finallydate=2019-11-17&area=太平
     */
    @RequestMapping("/HistogramWork")
    public String HistogramWork(String startdate,String finallydate,String area,HttpSession session) throws Exception {
        int histogramWork_sum = queryMapService.HistogramWork(startdate, finallydate, area);
        System.out.println("Controller------"+histogramWork_sum);
        session.setAttribute("histogramWork_sum",histogramWork_sum);
        return "Workload";
    }

    @RequestMapping("/HistogramWork1")
    public String HistogramWork1() throws Exception {
        return "Workload";
    }
}
