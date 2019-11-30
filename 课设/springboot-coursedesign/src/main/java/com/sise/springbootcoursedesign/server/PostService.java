package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.domain.Post;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @program: SpringBoot
 * @description: 快递实现类
 * @author: wxy
 * @create: 2019-11-16 16:45
 **/

@Service
@Transactional
public class PostService {

    @Resource
    private PostRepository postRepository;

    @Transactional
    public Post savePost(Post post){
        return postRepository.save(post);
    }

    @Transactional
    public void deleteById(int id){
        postRepository.deleteById(id);
    }

    public Post findById(int id){
        return postRepository.findById(id).get();
    }

    public Iterable<Post> findAllSort(Sort sort){
        return postRepository.findAll(sort);
    }

    public Iterable<Post> getByTargetAddressLike(Sort sort, String targetAddress){
        return postRepository.findByTargetAddressLike(sort, "%" + targetAddress + "%");
    }

    public List<Post> findLastMonthWorkload(int id){
        return postRepository.findLastMonthWorkload(id);
    }

    public Iterable<Post> findAllPostByPostmanId(int pno){
        return postRepository.findAllPostByPostmanId(pno);
    }

}
