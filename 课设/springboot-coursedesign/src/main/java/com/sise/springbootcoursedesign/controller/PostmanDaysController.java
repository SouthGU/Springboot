package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.domain.PostmanDays;
import com.sise.springbootcoursedesign.server.PostmanDaysService;
import com.sise.springbootcoursedesign.server.PostmanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @program: SpringBoot
 * @description: 签到、请假、加班天数
 * @author: wxy
 * @create: 2019-11-18 19:26
 **/

@Controller
public class PostmanDaysController {

    @Resource
    private PostmanDaysService postmanDaysService;
    @Resource
    private PostmanService postmanService;

    /**
     * @date: 2019/11/18
     * @description: 更新签到天数
     */

    @RequestMapping(value = "/updateWorkDays")
    public String updateWorkDays(@RequestParam(value = "pno") int pno, HttpSession session){
        Postman postman = postmanService.findById(pno);
        PostmanDays postmanDays = new PostmanDays();
        postmanDays.setWorkDays(1);
        postmanDays.setDate(new Date());
        postmanDays.setPostman2(postman);
        postmanDaysService.savePostmanDays(postmanDays);
        int number;
        if (postmanDaysService.savePostmanDays(postmanDays) != null){
            number = 10;
        }
        else {
            number = 11;
        }
        session.setAttribute("number", number);
        return "home_page";
    }

    /**
     * @date: 2019/11/18
     * @description: 更新请假天数
     */

    @RequestMapping(value = "/updateLeaveDays")
    public String updateLeaveDays(@RequestParam(value = "pno") int pno, HttpSession session){
        Postman postman = postmanService.findById(pno);
        PostmanDays postmanDays = new PostmanDays();
        postmanDays.setLeaveDays(1);
        postmanDays.setDate(new Date());
        postmanDays.setPostman2(postman);
        postmanDaysService.savePostmanDays(postmanDays);
        int number;
        if (postmanDaysService.savePostmanDays(postmanDays) != null){
            number = 10;
        }
        else {
            number = 11;
        }
        session.setAttribute("number", number);
        return "home_page";
    }

    /**
     * @date: 2019/11/18
     * @description: 更新加班天数
     */

    @RequestMapping(value = "/updateOvertimeDays")
    public String updateOvertimeDays(@RequestParam(value = "pno") int pno, HttpSession session) {
        Postman postman = postmanService.findById(pno);
        PostmanDays postmanDays = new PostmanDays();
        postmanDays.setOvertimeDays(1);
        postmanDays.setDate(new Date());
        postmanDays.setPostman2(postman);
        postmanDaysService.savePostmanDays(postmanDays);
        int number;
        if (postmanDaysService.savePostmanDays(postmanDays) != null){
            number = 10;
        }
        else {
            number = 11;
        }
        session.setAttribute("number", number);
        return "home_page";
    }

}
