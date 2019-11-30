package com.sise.springbootcoursedesign.dao;

import com.sise.springbootcoursedesign.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/21/23:43
 * @Description:
 */
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query("select count(id) from Admin where id=?1 and password=?2")
    int countAllByIdAndPassword(int id,String password);
}
