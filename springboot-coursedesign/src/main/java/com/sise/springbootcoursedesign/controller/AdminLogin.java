package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.server.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/21/23:42
 * @Description:
 */
@Controller
public class AdminLogin {

    @Autowired
    AdminService adminService;

    @RequestMapping("/adminlogin")
    public String countAllByIdAndPassword(String id,String password){
        int intid = Integer.parseInt(id);
        int i = adminService.countAllByIdAndPassword(intid,password);
        if(i>=1){
            System.out.println("查到该用户");
            return "Workload";
        }else {
            System.out.println("无");
            return "AdminLogin";
        }
    }
}
