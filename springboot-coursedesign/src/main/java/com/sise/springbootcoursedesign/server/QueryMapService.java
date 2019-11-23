package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanRepository;
import com.sise.springbootcoursedesign.domain.Postman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/18/19:09
 * @Description:
 */
@Service
public class QueryMapService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostmanRepository postmanRepository;

    public List<Integer> HistogramWork(String startdate,String finallydate,String area) throws Exception {
        //太平所有邮差的收派件计件数
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(startdate);
        Date date2 = formatter.parse(finallydate);
        int sum1 = postRepository.countsum1(date1,date2,area);
        System.out.println("太平派件签收:"+sum1);
        int sum2 = postRepository.countsum2(date1,date2,area);
        System.out.println("太平已计件数："+sum2);
        int SUM = sum1+sum2;
        System.out.println("太平所有邮差的收派件计件数:"+SUM);
        System.out.println("*******************");

        //太平所有邮差的收派件最大最小量
        List<Postman> postmanList = postmanRepository.findAll();
        System.out.println("全部快递员集合："+postmanList);
        List<Integer> list=new ArrayList<Integer>();
        for (Postman p:postmanList){
            int id = p.getId();
            //求出某个地区单个快递员本月的收件量
            int countOrderStatusPost =postRepository.countOrderStatusPost(date1,date2,id,area);
            System.out.println("编号为"+id+"的快递员本月总收件："+countOrderStatusPost);
            //求出某个地区单个快递员本月的派件量
            int countOutGoodsStatus = postRepository.countOutGoodsStatus(date1,date2,id,area);
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

        //将总和最大最小的数值放入集合中
        List<Integer> result=new ArrayList<Integer>();
        result.add(SUM);
        result.add(max);
        result.add(min);
        return result;
    }


    public List<String> areaArray(){
        List<String> areaArray = postRepository.areaArray();
        return areaArray;
    }
}
