package com.sise.springbootcoursedesign;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.UserRepository;
import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/0:33
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCoursedesignApplication.class)
@Rollback(value = false) //spring boot单元测试默认会事务回滚，故此需要强制不回滚注解，@Rollback(false)
public class test01 {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;


    /**
     * User对象获取数据，包括Post的数据
     */
    @Test
    @Transactional
    public void getUser(){
        User user = userRepository.getOne(1);

        System.out.println(user);               //代理对象
        System.out.println(user.getId());       //获取Id值
        System.out.println(user.getPassWord()); //获取密码

        Set<Post> posts = user.getPosts();
        for (Post p:posts) {
            System.out.println("Post的ID："+p.getId());
            System.out.println("Post所属区域+"+p.getArea());
            System.out.println("收件时间："+p.getGetDate());
            System.out.println("拒签理由："+p.getFailGetGoodsReason());
        }
    }

    /**
     * User填快递单表，将用户和快递单绑定在一起
     */
    @Test
    @Transactional
    public void Post_add_User() {

        Post post = new Post();
        post.setHouseAddress("广大华软");
        post.setTargetAddress("北京天安门");
        post.setPhone("110119115113");
        post.setArea("天平");
        post.setOrderStatus("否");
        post.setGetDate(new Date());

        //获取寄快递用户的属性值
        User user = userRepository.getOne(1);

        //将对象填充到post中，继而保存post
        post.setUser(user);
        postRepository.save(post);

    }
}
