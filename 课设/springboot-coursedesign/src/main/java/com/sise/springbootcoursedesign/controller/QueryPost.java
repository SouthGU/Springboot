package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.server.QueryMap3Service;
import com.sise.springbootcoursedesign.server.QueryPostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/20/15:43
 * @Description:
 */
@Controller
public class QueryPost {

    @Autowired
    QueryPostService queryPostService;

    @Autowired
    QueryMap3Service queryMap3Service;


    //收件管理系统
    @RequestMapping("QueryGetPost")
    public String QueryGetPost(String page, String size, HttpServletRequest httpSession){
        int PageInt = Integer.parseInt(page)-1;
        int SizeInt = Integer.parseInt(size);

        Page<Post> getpage = queryPostService.QueryGetPost(PageInt, SizeInt);
        httpSession.setAttribute("getpage",getpage);

        return "QueryGetPost";
    }

    //派件管理系统
    @RequestMapping("QueryOutPost")
    public String QueryOutPost(String page, String size, HttpServletRequest httpSession){
        int PageInt = Integer.parseInt(page)-1;
        int SizeInt = Integer.parseInt(size);

        Page<Post> outpage = queryPostService.QueryOutPost(PageInt, SizeInt);
        httpSession.setAttribute("outpage",outpage);

        return "QueryOutPost";
    }

    //派件管理系统
    @RequestMapping("PostCount")
    public String PostCount(String startdate,String finallydate,HttpServletRequest httpServletRequest) throws Exception {
        List<Integer> list = queryMap3Service.CirclePost(startdate, finallydate);
        System.out.println("list里面存放的统计数目： "+list);

        List<String> PostCountlist = new ArrayList<>();
        PostCountlist.add(startdate);
        PostCountlist.add(finallydate);


        httpServletRequest.setAttribute("post_list",list);
        httpServletRequest.setAttribute("PostCountlist",PostCountlist);

        return "PostCount";
    }

    //派件管理系统
    @RequestMapping("PostCount1")
    public String PostCount1() {
        return "PostCount";
    }

}
