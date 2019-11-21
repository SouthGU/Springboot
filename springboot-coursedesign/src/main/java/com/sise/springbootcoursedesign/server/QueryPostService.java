package com.sise.springbootcoursedesign.server;

import com.sise.springbootcoursedesign.dao.PostRepository;
import com.sise.springbootcoursedesign.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
/**
 * @Auther: sise.xgl
 * @Date: 2019/11/20/15:47
 * @Description:
 */
@Service
public class QueryPostService {

    @Autowired
    PostRepository postRepository;

    public Page<Post> QueryGetPost(int page, int size){

        Pageable pageable = PageRequest.of(page,size);

        Specification<Post> specification =new Specification<Post>(){
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //查询条件
                Predicate p1 = criteriaBuilder.equal(root.get("orderStatus").as(String.class), "是");
                query.where(criteriaBuilder.and(p1));
                return query.getRestriction();
            }
        };
        Page<Post> page1 = postRepository.findAll(specification,pageable);
        return page1;
    }


    public Page<Post> QueryOutPost(int page, int size){

        Pageable pageable = PageRequest.of(page,size);

        Specification<Post> specification =new Specification<Post>(){
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //查询条件
                Predicate p1 = criteriaBuilder.equal(root.get("getGoodsStatus").as(String.class), "收件成功");
                query.where(criteriaBuilder.and(p1));
                return query.getRestriction();
            }
        };
        Page<Post> page1 = postRepository.findAll(specification,pageable);
        return page1;
    }
}
