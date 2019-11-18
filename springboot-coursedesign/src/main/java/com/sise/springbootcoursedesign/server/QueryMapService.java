package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/18/19:09
 * @Description:
 */
@Service
public class QueryMapService {

    @Autowired
    PostRepository postRepository;

    public int HistogramWork(String startdate,String finallydate,String area) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(startdate);
        Date date2 = formatter.parse(finallydate);
        int sum1 = postRepository.countsum1(date1,date2,area);
        System.out.println("太平派件签收:"+sum1);
        int sum2 = postRepository.countsum2(date1,date2,area);
        System.out.println("太平已计件数："+sum2);
        int SUM = sum1+sum2;
        System.out.println("太平所有邮差的收派件计件数:"+SUM);
        return SUM;
    }
}
