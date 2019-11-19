package com.sise.springbootcoursedesign.dao;

import com.sise.springbootcoursedesign.domain.Postman;
import com.sise.springbootcoursedesign.domain.PostmanDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/0:31
 * @Description:
 */
public interface PostmanDaysRepository extends JpaRepository<PostmanDays,Integer>,JpaSpecificationExecutor<PostmanDays> {

    @Query("select count(leaveDays) from PostmanDays where postman2.id =?1 and date between ?2 and ?3 and leaveDays='1'")
    int countLeaveDays(int id, Date startDate, Date finallyDate);

    @Query("select count(workDays) from PostmanDays where postman2.id =?1 and date between ?2 and ?3 and workDays='1'")
    int countWorkDays(int id, Date startDate, Date finallyDate);

    @Query("select count(overtimeDays) from PostmanDays where postman2.id =?1 and date between ?2 and ?3 and overtimeDays='1'")
    int countOvertimeDays(int id, Date startDate, Date finallyDate);
}
