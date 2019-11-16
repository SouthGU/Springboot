package com.sise.springbootcoursedesign.dao;

import com.sise.springbootcoursedesign.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/0:29
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
