package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostmanDaysRepository;
import com.sise.springbootcoursedesign.domain.PostmanDays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/19/15:40
 * @Description:
 */
@Service
public class QueryMap2Service {

    @Autowired
    PostmanDaysRepository postmanDaysRepository;

    public List<Integer> CircleWork(String startdate,String finallydate,int postmanid) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate2 = formatter.parse(startdate);
        Date finallydate2 = formatter.parse(finallydate);

        //请假的天数
        int countLeaveDays = postmanDaysRepository.countLeaveDays(postmanid, startdate2, finallydate2);
        System.out.println("快递员ID为"+postmanid+"的请假的天数："+countLeaveDays);

        //加班的天数
        int countOvertimeDays = postmanDaysRepository.countOvertimeDays(postmanid,startdate2,finallydate2);
        System.out.println("快递员ID为"+postmanid+"加班的天数："+countOvertimeDays);

        //工作的天数
        int countWorkDays = postmanDaysRepository.countWorkDays(postmanid,startdate2,finallydate2);
        System.out.println("快递员ID为"+postmanid+"工作的天数："+countWorkDays);

        List<Integer> list = new ArrayList<>();
        list.add(countWorkDays);
        list.add(countOvertimeDays);
        list.add(countLeaveDays);

        return list;
    }

}
