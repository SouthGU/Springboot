package com.sise.springbootcoursedesign;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanRepository;
import com.sise.springbootcoursedesign.dao.UserRepository;
import com.sise.springbootcoursedesign.domain.Post;
import javafx.geometry.Pos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCoursedesignApplication.class)
@Rollback(value = false) //spring boot单元测试默认会事务回滚，故此需要强制不回滚注解，@Rollback(false)
public class test06 {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostmanRepository postmanRepository;


    /**
     * 分页：
     * 如派件：准备派件—谁派件---正在派件（路上）--派件签收或没成功派件（原因）
     * 如收件：准备收件----谁收件----收件完成-或收件不成功（原因）
     * 统计：按月或天分别统计RSC系统邮件发件量、收件量及故障件数。
     * pageNum - 1,pageLimit
     *
     * 快递员接单为 "是" 的快递就全部查询出来 显示 收件状态
     * 收件状态为 "成功" 的快递就全部查询出来 显示 派件状态
     */
    @Test
    @Transactional
    public void postman_add_post() {

        Pageable pageRequest = PageRequest.of(0, 5);
        Page<Post> page = postRepository.findAll(pageRequest);

        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("当前第几页："+page.getNumber());
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("当前页面的List："+page.getContent());
        System.out.println("当前页面的记录数："+page.getNumberOfElements());

        for (Post p : page){
            System.out.println(p.getId());
        }
    }


    /**
     * 求出快递中所有的区域并显示出来
     */
    @Test
    @Transactional
    public void postman_add_post1() {
        List<String> integers = postRepository.areaArray();
        System.out.println(integers);
        for (int i=1;i<integers.size();i++){
            System.out.println(integers.get(i));
        }

    }


    @Test
    @Transactional
    public void postman_add_post2() {

        for (int i =1 ; i<40;i++){
            Post one = postRepository.getOne(i);
//            one.setOutGoodsStatus("派件签收");
//            one.setGetGoodsStatus("收件成功");
            one.setOutGoodsFault("是");
//            one.setGetDate(new Date());
            one.setOutDate(new Date());
//            one.setOrderStatus("是");
            postRepository.save(one);

        }

    }
}
