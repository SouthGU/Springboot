package com.sise.springbootcoursedesign;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanRepository;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/0:33
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCoursedesignApplication.class)
@Rollback(value = false) //spring boot单元测试默认会事务回滚，故此需要强制不回滚注解，@Rollback(false)
public class test04 {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostmanRepository postmanRepository;

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
        String finalDate = "2019-11-17";
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
     * 1)查询某月按区域地址所有邮差（邮递员）的最大工作量
     */
    @Test
    @Transactional
    public void SUM_POST_WORK2(){

    }



    /**
     * 1)查询某月按区域地址所有邮差（邮递员）的最小工作量
     */
    @Test
    @Transactional
    public void SUM_POST_WORK3(){

    }


}
