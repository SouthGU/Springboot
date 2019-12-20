package com.oujiong.wechatpay.controller;

import com.oujiong.wechatpay.domain.Video;
import com.oujiong.wechatpay.server.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/12/19/22:34
 * @Description:
 */
@Controller
public class addgoodsController {

    @Autowired
    VideoService videoService;
    @RequestMapping("/addgoods")
    public String addgoods(Video video, HttpSession session){
        videoService.save(video);
        List<Video> videoList = videoService.findAll();
       session.setAttribute("videoList",videoList);
        return "/show";
    }

    @RequestMapping("/findall")
    public String findall(HttpSession session){
        List<Video> videoList = videoService.findAll();
        session.setAttribute("videoList",videoList);
        return "/show";
    }

}
