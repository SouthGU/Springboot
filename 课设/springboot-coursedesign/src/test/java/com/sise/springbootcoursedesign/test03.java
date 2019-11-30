package com.sise.springbootcoursedesign;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanRepository;
import com.sise.springbootcoursedesign.dao.UserRepository;
import com.sise.springbootcoursedesign.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * 1)	#按月或天分别统计RSC系统邮件收件量：判断是否 收件失败
     *      SELECT COUNT(*) FROM post WHERE
     *      get_date BETWEEN '2019-11-16 16:14:42' and '2019-11-17'
     *      AND get_goods_fault = '否';
     *      参数：String getGoodsStatus,String startDate, String finalDate
     */
    @Test
    @Transactional
    public void postman_add_post4() throws Exception {
        String getGoodsStatus = "否";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "2019-11-16";
        String finalDate = "2019-11-17";
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(finalDate);

        long posts = postRepository.countByGetGoodsFaultAndGetDateBetween(getGoodsStatus,date1,date2);
        System.out.println(posts);
    }

    /**
     * 1)	#按月或天分别统计RSC系统邮件派件量，判断是否 签收完毕
     *      SELECT COUNT(*) FROM post WHERE
     *      post.get_date BETWEEN '2019-11-16 16:14:42' and '2019-11-17'
     *      AND out_goods_status = '派件签收';
     */
    @Test
    @Transactional
    public void postman_add_post5() throws Exception {
        String outGoodsStatus = "派件签收";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "2019-11-10";
        String finalDate = "2019-11-10";
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(finalDate);

        long posts = postRepository.countByOutGoodsStatusAndGetDateBetween(outGoodsStatus,date1,date2);
        System.out.println("签收完毕"+posts);
    }

    /**
     * 1)	#按月或天分别统计RSC系统邮件障件数
     *      SELECT COUNT(*) FROM post WHERE
     *      post.get_date BETWEEN '2019-11-16 16:14:42' and '2019-11-17'
     *      AND out_goods_fault = '是';
     */
    @Test
    @Transactional
    public void postman_add_post6() throws Exception {
        String outGoodsFault = "是";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "2019-11-16";
        String finalDate = "2019-11-17";
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(finalDate);

        long posts = postRepository.countByOutGoodsFaultAndGetDateBetween(outGoodsFault,date1,date2);
        System.out.println("邮件障件数:"+posts);
    }
}
