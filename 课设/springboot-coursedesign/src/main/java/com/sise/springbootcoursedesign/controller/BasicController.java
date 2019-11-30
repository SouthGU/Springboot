package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.server.PostService;
import com.sise.springbootcoursedesign.server.PostmanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: SpringBoot
 * @description: basic
 * @author: wxy
 * @create: 2019-11-20 20:13
 **/

@RestController
public class BasicController {

    @Resource
    private PostService postService;
    @Resource
    private PostmanService postmanService;

    @RequestMapping(value = "/findLastMonthWorkload")
    public String findLastMonthWorkload(@RequestParam(value = "pno") int pno, @RequestParam(value = "standardWorkload") int standardWorkload, HttpSession session){
        List<Post> posts = postService.findLastMonthWorkload(pno);
        String fate;
        if (standardWorkload > (posts.size() + 50) || standardWorkload < (posts.size() - 100)){
            fate = "0";
        }
        else {
            fate = "1";
            Postman postman = postmanService.findById(pno);
            postman.setStandardWorkload(standardWorkload);
            postmanService.savePostman(postman);
        }
        session.setAttribute("fate", fate);
        return fate;
    }

}
