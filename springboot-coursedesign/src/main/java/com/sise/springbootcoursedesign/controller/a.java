package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    PostRepository postRepository;
    @RequestMapping("/a")
    public String a(HttpSession session){
        Postman postman = new Postman();
        postman.setBasicPay(66);
        int a =33;
        session.setAttribute("test",postman);
        return "HistogramWork";
    }

    @RequestMapping("/CircleWork")
    public String test2(HttpSession session){

        return "CircleWork";
    }

    @RequestMapping("/QueryOutPost1")
    public String test1(HttpSession session){
        Pageable pageRequest = PageRequest.of(1, 10);
        Page<Post> page = postRepository.findAll(pageRequest);

        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("当前第几页："+page.getNumber());
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("当前页面的List："+page.getContent());
        System.out.println("当前页面的记录数："+page.getNumberOfElements());

            List<Post> content = page.getContent();

        for (Post p : content){
            p.getId();
            p.getFailGetGoodsReason();

        }
        session.setAttribute("outpage",page);
        return "QueryOutPost";
    }
}
