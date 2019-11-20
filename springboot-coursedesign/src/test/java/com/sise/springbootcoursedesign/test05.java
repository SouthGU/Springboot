package com.sise.springbootcoursedesign;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanDaysRepository;
import com.sise.springbootcoursedesign.dao.PostmanRepository;
import com.sise.springbootcoursedesign.dao.UserRepository;
import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.domain.PostmanDays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/19/11:59
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCoursedesignApplication.class)
@Rollback(value = false) //spring boot单元测试默认会事务回滚，故此需要强制不回滚注解，@Rollback(false)
public class test05 {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostmanRepository postmanRepository;
    @Autowired
    PostmanDaysRepository postmanDaysRepository;

    /**
     *  #1)	查询某月按区域地址所有邮差（邮递员）的工作量（收派件计件数）
     * SELECT  COUNT(*) FROM post
     * WHERE post.out_date BETWEEN '2019-11-10 16:14:42' and '2020-11-17'
     * AND post.out_goods_status = "派件签收"
     * ;
     *
     * #1)	查询某月按区域地址所有邮差（邮递员）的工作量（收派件计件数）
     * SELECT  COUNT(*) FROM post
     * WHERE post.get_date BETWEEN '2019-11-10 16:14:42' and '2020-11-17'
     * AND post.order_status = "是"
     * ;
     */
    @Test
    @Transactional
    public void SUM_POST_WORK() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "2019-11-16";
        String finalDate = "2019-11-30";
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(finalDate);
        String area = "太平";
        int sum1 = postRepository.countsum1(date1,date2,area);
        System.out.println("太平派件签收:"+sum1);

        Date date3 = formatter.parse(startDate);
        Date date4 = formatter.parse(finalDate);
        int sum2 = postRepository.countsum2(date3,date4,area);
        System.out.println("太平已计件数："+sum2);

        int SUM = sum1+sum2;
        System.out.println("太平所有邮差的收派件计件数:"+SUM);
    }

    /**
     * 先遍历出所有的快递员集合，遍历取出快递员的编号，通过
     * SELECT COUNT(order_status) FROM post
     * WHERE post.postman_id ="1"
     * AND post.get_date BETWEEN '2019-11-10 16:14:42' and '2020-11-17'
     * AND post.order_status = "是"
     * #AND post.out_goods_status = "派件签收"
     * ;
     * 分别取出该位快递员的收件量，派件量相加，并相加
     * 最后通过对比取出最大最小值
     */
    @Test
    @Transactional
    public void SUM_POST_WORK4() throws Exception {
        List<Postman> postmanList = postmanRepository.findAll();
        System.out.println("全部快递员集合："+postmanList);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "2019-11-16";
        String finalDate = "2019-11-31";
        Date startdate = formatter.parse(startDate);
        Date finallydate = formatter.parse(finalDate);
        String area = "太平";

        //定义数组，存放每个快递员本月的总工作量
        List<Integer> list=new ArrayList<Integer>();
        for (Postman p:postmanList){
            int id = p.getId();
            //求出某个地区单个快递员本月的收件量
            int countOrderStatusPost =postRepository.countOrderStatusPost(startdate,finallydate,id,area);
            System.out.println("编号为"+id+"的快递员本月总收件："+countOrderStatusPost);
            //求出某个地区单个快递员本月的派件量
            int countOutGoodsStatus = postRepository.countOutGoodsStatus(startdate,finallydate,id,area);
            System.out.println("编号为"+id+"的快递员本月总派件："+countOutGoodsStatus);
            //求出该位快递员的收派件总和
            int sum = countOrderStatusPost + countOutGoodsStatus;
            System.out.println("该位快递员的收派件总和"+sum);
            System.out.println("-----------------");
            list.add(sum);
        }
        System.out.println(list);
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println("该地区本月快递员的最大收派件为："+max);
        System.out.println("该地区本月快递员的最小收派件为："+min);

    }

    /**
     * 能够查询某个邮差某月的工作情况（在岗天数、请假天数、加班天数），要求以饼图的方式进行显示；
     *
     * 请假：
     * select COUNT(leave_days) from postdays
     * WHERE postman_id = '1'
     * AND date BETWEEN '2019-11-1 20:18:52' AND '2019-11-31 20:18:52'
     * AND leave_days='1'
     * ;
     */
    @Test
    @Transactional
    public void SUM_POST_WORK5() throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "2019-11-16";
        String finalDate = "2019-11-31";
        Date startdate = formatter.parse(startDate);
        Date finallydate = formatter.parse(finalDate);
        int id = 3;

        //请假的天数
        int countLeaveDays = postmanDaysRepository.countLeaveDays(id, startdate, finallydate);
        System.out.println("快递员ID为"+id+"的请假的天数："+countLeaveDays);

        //加班的天数
        int countOvertimeDays = postmanDaysRepository.countOvertimeDays(id,startdate,finallydate);
        System.out.println("快递员ID为"+id+"加班的天数："+countOvertimeDays);

        //工作的天数
        int countWorkDays = postmanDaysRepository.countWorkDays(id,startdate,finallydate);
        System.out.println("快递员ID为"+id+"工作的天数："+countWorkDays);

    }



    @Test
    @Transactional
    public void SUM_POST_WORK6() throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "2019-11-16";
        String finalDate = "2019-11-31";
        Date startdate = formatter.parse(startDate);
        Date finallydate = formatter.parse(finalDate);

        int countGetPost = postRepository.countGetPost(startdate, finallydate);
        System.out.println(countGetPost);

    }



}
