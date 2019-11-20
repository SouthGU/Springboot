package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.dao.PostmanDaysRepository;
import com.sise.springbootcoursedesign.domain.Post;
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
public class QueryMap3Service {

    @Autowired
    PostRepository postRepository;

    public List<Integer> CirclePost(String startdate,String finallydate) throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate2 = formatter.parse(startdate);
        Date finallydate2 = formatter.parse(finallydate);

        //收件成功的数目
        int countGetPost = postRepository.countGetPost(startdate2, finallydate2);
        //收件成功的数目
        int countOutPost = postRepository.countOutPost(startdate2, finallydate2);
        //收件成功的数目
        int countFailPost = postRepository.countFailPost(startdate2, finallydate2);

        List<Integer> list = new ArrayList<>();
        list.add(countGetPost);
        list.add(countOutPost);
        list.add(countFailPost);

        return list;
    }

}
