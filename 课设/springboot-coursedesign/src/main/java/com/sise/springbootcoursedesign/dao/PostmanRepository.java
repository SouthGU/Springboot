package com.sise.springbootcoursedesign.dao;

import com.sise.springbootcoursedesign.domain.Post;
import com.sise.springbootcoursedesign.domain.Postman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/0:31
 * @Description:
 */
public interface PostmanRepository extends JpaRepository<Postman,Integer>,JpaSpecificationExecutor<Postman> {


    /**
     * @date: 2019/11/25
     * @description: xgl
     */

    @Query("select count(id) from Postman where id = ?1")
    int  countById(int id);

    /**
     * @date: 2019/11/25
     * @description: wxy
     */

    boolean existsById(int pno);


    @Query(name = "select * from Postman where area=?1",nativeQuery = true)
    List<Postman> findByArea(String area);


}
