package com.sise.springbootcoursedesign;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanRepository;
import com.sise.springbootcoursedesign.dao.UserRepository;
import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCoursedesignApplication.class)
@Rollback(value = false) //spring boot单元测试默认会事务回滚，故此需要强制不回滚注解，@Rollback(false)
public class test03 {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostmanRepository postmanRepository;


    /**
     * 派件：准备派件—谁派件---正在派件（路上）--派件签收或没成功派件（原因）
     */
    @Test
    @Transactional
    public void postman_add_post() {

        List<Post> posts = postRepository.findAll();
        for(Post p : posts){
            System.out.println("快递的派件情况： "+p.getOutGoodsStatus());
            System.out.println("快递的派件人： "+p.getPostman().getPostmanName());
            System.out.println("快递的派件次数： "+p.getOutGoodsNumber());
            System.out.println("派件失败的原因： "+p.getFailOutGoodsReason());
            System.out.println("---------------------------------");
        }
    }



    /**
     * 如收件：准备收件----谁收件----收件完成-或收件不成功（原因）
     */
    @Test
    @Transactional
    public void postman_add_post2() {

        List<Post> posts = postRepository.findAll();
        for(Post p : posts){
            System.out.println("快递的收件情况： "+p.getGetGoodsStatus());
            System.out.println("收件的快递员： "+p.getPostman().getPostmanName());
            System.out.println("收件失败的原因： "+p.getFailGetGoodsReason());
            System.out.println("---------------------------------");
        }
    }

    /**
     * 统计：按月或天分别统计RSC系统邮件发件量、收件量及故障件数。
     */
    @Test
    @Transactional
    public void postman_add_post3() {

        List<Post> posts = postRepository.findAll();
        for(Post p : posts){
            System.out.println("快递的收件情况： "+p.getGetGoodsStatus());
            System.out.println("收件的快递员： "+p.getPostman().getPostmanName());
            System.out.println("收件失败的原因： "+p.getFailGetGoodsReason());
            System.out.println("---------------------------------");
        }
    }

    /**
     * 1)	查询某月按区域地址所有邮差（邮递员）的工作量（收派件计件数），
     *      最大工作量和最小工作量，要求能够以直方图显示；
     */
    @Test
    @Transactional
    public void postman_add_post4() {
        //查询某月的区域的所有邮差



    }

}
