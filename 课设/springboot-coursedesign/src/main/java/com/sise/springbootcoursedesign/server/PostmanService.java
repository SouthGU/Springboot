package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostmanRepository;
import com.sise.springbootcoursedesign.domain.Postman;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot
 * @description: 快递员实现类
 * @author: wxy
 * @create: 2019-11-16 16:42
 **/

@Service
@Transactional
public class PostmanService {

    @Resource
    private PostmanRepository postmanRepository;

    @Transactional
    public Postman savePostman(Postman postman){
        return postmanRepository.save(postman);
    }

    public Iterable<Postman> findAllSort(Sort sort){
        return postmanRepository.findAll(sort);
    }

    public Postman findById(int id){
        return postmanRepository.findById(id).get();
    }

    public boolean existsById(int pno){
        return postmanRepository.existsById(pno);
    }

    public List<Map<String, Object>> getPersonalInformation(Postman postman){
        List<Map<String, Object>> results = new ArrayList<>();
        Map<String , Object> map = new HashMap<>();
        map.put("id", postman.getId());
        map.put("postmanName", postman.getPostmanName());
        map.put("password", postman.getPassword());
        map.put("getGoodsTotal", postman.getGetGoodsTotal());
        map.put("outGoodsTotal", postman.getOutGoodsTotal());
        map.put("basicPay", postman.getBasicPay());
        map.put("salary", postman.getSalary());
        map.put("area", postman.getArea());
        results.add(map);
        return results;
    }

}
