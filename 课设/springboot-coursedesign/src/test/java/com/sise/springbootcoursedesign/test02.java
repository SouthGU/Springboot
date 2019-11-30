package com.sise.springbootcoursedesign;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanDaysRepository;
import com.sise.springbootcoursedesign.dao.PostmanRepository;
import com.sise.springbootcoursedesign.dao.UserRepository;
import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.domain.PostmanDays;
import com.sise.springbootcoursedesign.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCoursedesignApplication.class)
@Rollback(value = false) //spring boot单元测试默认会事务回滚，故此需要强制不回滚注解，@Rollback(false)
public class test02 {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostmanRepository postmanRepository;
    @Autowired
    PostmanDaysRepository postmanDaysRepository;


    /**
     * 快递员查询无人接单的快递，并点击按钮接单
     */
    @Test
    @Transactional
    public void postman_add_post(){
        Postman postman = postmanRepository.getOne(1);

        List<Post> posts =postRepository.findAllByOrderStatus("否");
        //System.out.println(posts);
        for (Post p: posts) {
            System.out.println("无人接单的快递ID:"+p.getId());
            System.out.println("无人接单的快递自家地址:"+p.getHouseAddress());
            System.out.println("无人接单的快递目标地址:"+p.getTargetAddress());
            System.out.println("无人接单的快递手机号码:"+p.getPhone());
            System.out.println("无人接单的快递所属区域:"+p.getArea());
            System.out.println("---------------------");
        }

        //假设点击接收POST_ID为1的快递单
        Post post = postRepository.getOne(1);
        post.setPostman(postman);
        postRepository.save(post);


        //重新查询ID为1的快递员为谁
        Post post1 = postRepository.getOne(1);
        System.out.println(post1.getPostman().getPostmanName());
    }

    /**
     * 快递员点击在岗，请假，加班按钮
     */
    @Test
    @Transactional
    public void PostmanDays(){

        Postman postman = postmanRepository.getOne(1);
        Set<PostmanDays> postmandays = postman.getPostmandays();
        for (PostmanDays p:postmandays) {
            System.out.println(p.getOvertimeDays());
            System.out.println(p.getLeaveDays());
            System.out.println(p.getWorkDays());
        }
    }




}
