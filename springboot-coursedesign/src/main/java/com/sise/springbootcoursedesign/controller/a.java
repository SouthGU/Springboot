package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/17/2:01
 * @Description:
 */
@Controller
public class a {
    @RequestMapping("/a")
    public String a(HttpSession session){
        Postman postman = new Postman();
        postman.setBasicPay(66);
        int a =33;
        session.setAttribute("test",postman);
        return "HistogramWork";
    }

    @RequestMapping("/test2")
    public String test2(HttpSession session){
        Postman postman = new Postman();
        postman.setBasicPay(66);
        int a =33;
        session.setAttribute("test3",postman);
        return "test2";
    }

    @RequestMapping("/test1")
    public String test1(HttpSession session){
        Postman postman = new Postman();
        postman.setBasicPay(66);
        int a =33;
        return "test2";
    }
}
