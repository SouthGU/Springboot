package com.sise.springbootcoursedesign.controller;

import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.server.PostService;
import com.sise.springbootcoursedesign.server.PostmanService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @program: SpringBoot
 * @description: 邮件控制层
 * @author: wxy
 * @create: 2019-11-15 22:01
 **/

@Controller
public class PostController {

    @Resource
    private PostService postService;
    @Resource
    private PostmanService postmanService;

    @RequestMapping(value = "/login")
    public String test() {
        return "login";
    }

    /**
     * @date: 2019/11/16
     * @description: 得到所有未接快递
     */

    @RequestMapping(value = "/findMissOrder")
    public String missOrder(@RequestParam(value = "pno") int pno, HttpSession session) {
        int code = 1;
        Postman postman = postmanService.findById(pno);
        String area = postman.getArea();
        session.setAttribute("code", code);
        sortPost(area, session);
        return "home_page";
    }

    /**
     * @date: 2019/11/17
     * @description: 得到所有已接单
     */

    @RequestMapping(value = "/findSuccessfulReceipt")
    public String findReceivedOrder(@RequestParam(value = "pno") int pno, HttpSession session) {
        int code = 2;
        session.setAttribute("code", code);
        findAllPostByPostmanId(pno, session);
        return "home_page";
    }

    /**
     * @date: 2019/11/21
     * @description: 得到所有未收件成功快递
     */

    @RequestMapping(value = "/findUndeliveredExpress")
    public String findUndeliveredExpress(@RequestParam(value = "pno") int pno, HttpSession session){
        int code = 3;
        session.setAttribute("code", code);
        findAllPostByPostmanId(pno, session);
        return "home_page";
    }

    /**
     * @date: 2019/11/16
     * @description: 更新派送剩余次数及故障状态
     */

    @RequestMapping(value = "/updateOutGoodsNumber")
    public String updateOutGoodsNumber(@RequestParam(value = "eno") int eno, @RequestParam(value = "pno") int pno,  @RequestParam(value = "text") String text, @RequestParam(value = "area") String area, HttpSession session) {
        Post post = postService.findById(eno);
        String reason = post.getFailOutGoodsReason();
        if("".equals(reason)){
            reason = text;
        }
        else {
            reason = reason + "," + text;
        }
        post.setFailOutGoodsReason(reason);
        post.setOutDate(new Date());
        int outGoodsNumber = post.getOutGoodsNumber();
        if (outGoodsNumber == 1) {
            post.setOutGoodsNumber(0);
            post.setOutGoodsFault("是");
            postService.savePost(post);
        } else {
            outGoodsNumber -= 1;
            post.setOutGoodsNumber(outGoodsNumber);
            postService.savePost(post);
        }
        findAllPostByPostmanId(pno, session);
        return "home_page";
    }

    /**
     * @date: 2019/11/17
     * @description: 更新收件状态及已接单
     */

    @RequestMapping(value = "/updateOrderStatus")
    public String updateOrderStatus(@RequestParam(value = "eno") int eno, @RequestParam(value = "pno") int pno, @RequestParam(value = "area") String area, HttpSession session) {
        int num;
        Post post = postService.findById(eno);
        if (post.getOrderStatus().equals("否")){
            Postman postman = postmanService.findById(pno);
            post.setPostman(postman);
            post.setOrderStatus("是");
            post.setGetGoodsStatus("准备收件");
            postService.savePost(post);
            num = 20;
        }
        else {
            num = 21;
        }
        session.setAttribute("num", num);
        sortPost(area, session);
        return "home_page";
    }

    /**
     * @date: 2019/11/25
     * @description: 更新收件故障
     */

    @RequestMapping(value = "/updateGetGoods")
    public String updateOutGoods(@RequestParam(value = "eno") int eno, @RequestParam(value = "pno") int pno,  @RequestParam(value = "text") String text, HttpSession session){
        Post post = postService.findById(eno);
        post.setGetGoodsFault("是");
        System.out.println(eno);
        post.setFailGetGoodsReason(text);
        postService.savePost(post);
        findAllPostByPostmanId(pno, session);
        return "home_page";
    }

    /**
     * @date: 2019/11/17
     * @description: 开始派件
     */

    @RequestMapping(value = "/updateStartDispatching")
    public String updateStartDispatching(@RequestParam(value = "eno") int eno, @RequestParam(value = "pno") int pno, HttpSession session){
        Post post = postService.findById(eno);
        post.setOutGoodsStatus("正在派件");
        postService.savePost(post);
        findAllPostByPostmanId(pno, session);
        return "home_page";
    }

    /**
     * @date: 2019/11/16
     * @description: 按剩余次数排序输出
     */

    public void sortPost(String area, HttpSession session) {
        Sort sort = Sort.by(Sort.Direction.ASC, "outGoodsNumber");
        Iterable<Post> PostDates = postService.getByTargetAddressLike(sort, area);
        session.setAttribute("sort", PostDates);
    }

    /**
     * @date: 2019/11/21
     * @description: 根据快递员编号找出所有快递
     */

    public void findAllPostByPostmanId(int pon, HttpSession session){
        Sort sort = Sort.by(Sort.Direction.ASC, "outGoodsNumber");
        Iterable<Post> PostDates = postService.findAllPostByPostmanId(pon);
        session.setAttribute("post", PostDates);
    }


}