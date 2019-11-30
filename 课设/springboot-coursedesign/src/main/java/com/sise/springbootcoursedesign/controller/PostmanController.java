package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.server.PostmanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot
 * @description: 快递员控制类
 * @author: wxy
 * @create: 2019-11-17 10:09
 **/

@Controller
public class PostmanController {

    @Resource
    private PostmanService postmanService;

    @RequestMapping(value = "/h")
    public String h(){
        return "navigation";
    }

    /**
     * @date: 2019/11/22
     * @description: 登录验证
     */

    @RequestMapping(value = "/validateLogon")
    public String validateLogon(@RequestParam(value = "pno") int pno, @RequestParam(value = "password") String password, HttpSession session){
        int value;
        if (postmanService.existsById(pno)){
            Postman postman = postmanService.findById(pno);
            if (postman.getPassword().equals(password)){
                findPersonalInformation(pno, session);
                return "home_page";
            }
            else {
                value = 0;
                session.setAttribute("value", value);
                return "login";
            }
        }
        else {
            value = 1;
            session.setAttribute("value", value);
            return "login";
        }
    }

    /**
     * @date: 2019/11/17
     * @description: 输出快递员的信息
     */

    @RequestMapping(value = "/findPersonalInformation")
    public String findPersonalInformation(@RequestParam(value = "pno") int pno, HttpSession session){
        Postman postman = postmanService.findById(pno);
        int salary = postman.getBasicPay() + (postman.getGetGoodsTotal() + postman.getOutGoodsTotal()) * 10;
        postman.setSalary(salary);
        postmanService.savePostman(postman);
        List<Map<String, Object>> results = postmanService.getPersonalInformation(postman);
        int code = 0;
        int standardWorkload = postman.getStandardWorkload();
        String area = postman.getArea();
        session.setAttribute("pno", pno);
        session.setAttribute("area", area);
        session.setAttribute("code", code);
        session.setAttribute("postman", results);
        session.setAttribute("standardWorkload", standardWorkload);
        return "home_page";
    }

}
