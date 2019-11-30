package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostmanDaysRepository;
import com.sise.springbootcoursedesign.domain.PostmanDays;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot
 * @description: 签到、请假、加班天数
 * @author: wxy
 * @create: 2019-11-18 19:19
 **/

@Service
@Transactional
public class PostmanDaysService {

    @Resource
    PostmanDaysRepository postmanDaysRepository;

    @Transactional
    public PostmanDays savePostmanDays(PostmanDays postmanDays){
        return postmanDaysRepository.save(postmanDays);
    }

    public PostmanDays findById(int id){
        return postmanDaysRepository.findById(id).get();
    }

    public List<Map<String, Object>> getPersonalDays(PostmanDays postmanDays){
        List<Map<String, Object>> results = new ArrayList<>();
        Map<String , Object> map = new HashMap<>();
        map.put("id", postmanDays.getId());
        map.put("workDays", postmanDays.getWorkDays());
        map.put("leaveDays", postmanDays.getLeaveDays());
        map.put("overtimeDays", postmanDays.getOvertimeDays());
        results.add(map);
        return results;
    }

}
