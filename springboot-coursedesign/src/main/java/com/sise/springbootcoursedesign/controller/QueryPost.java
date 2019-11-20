package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.server.QueryPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/20/15:43
 * @Description:
 */
@Controller
public class QueryPost {

    @Autowired
    QueryPostService queryPostService;


    //收件管理系统
    @RequestMapping("QueryGetPost")
    public String QueryGetPost(String page, String size, HttpSession httpSession){
        int PageInt = Integer.parseInt(page)-1;
        int SizeInt = Integer.parseInt(size);

        Page<Post> getpage = queryPostService.QueryGetPost(PageInt, SizeInt);
        httpSession.setAttribute("getpage",getpage);

        return "QueryGetPost";
    }

    //派件管理系统
    @RequestMapping("QueryOutPost")
    public String QueryOutPost(String page, String size, HttpSession httpSession){
        int PageInt = Integer.parseInt(page)-1;
        int SizeInt = Integer.parseInt(size);

        Page<Post> outpage = queryPostService.QueryOutPost(PageInt, SizeInt);
        httpSession.setAttribute("outpage",outpage);

        return "QueryOutPost";
    }

    //派件管理系统
    @RequestMapping("PostCount")
    public String PostCount(Date startDate,Date finallyDate){

        return "PostCount";
    }


}
