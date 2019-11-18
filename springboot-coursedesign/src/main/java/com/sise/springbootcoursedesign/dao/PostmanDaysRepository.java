package com.sise.springbootcoursedesign.dao;

import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.domain.PostmanDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/0:31
 * @Description:
 */
public interface PostmanDaysRepository extends JpaRepository<PostmanDays,Integer>,JpaSpecificationExecutor<PostmanDays> {
}
