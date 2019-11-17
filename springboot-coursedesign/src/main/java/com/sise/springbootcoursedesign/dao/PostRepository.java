package com.sise.springbootcoursedesign.dao;

import com.sise.springbootcoursedesign.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/0:31
 * @Description:
 */
public interface PostRepository extends JpaRepository<Post,Integer>, JpaSpecificationExecutor<Post> {

    List<Post> findAllByOrderStatus(String OrderStatus);

    long countByOutGoodsStatusAndGetDateBetween(String outGoodsStatus, Date date1, Date date2);

    long countByGetGoodsFaultAndGetDateBetween(String getGoodsStatus, Date date1, Date date2);

    long countByOutGoodsFaultAndGetDateBetween(String outGoodsFault, Date date1, Date date2);

    @Query("select count(outGoodsStatus) from Post where outDate BETWEEN ?1 and ?2 and area=?3 and outGoodsStatus='派件签收'")
    int countsum1(Date startDate,Date finallyDate,String area);

    @Query("SELECT count(orderStatus) from Post where getDate BETWEEN ?1 and ?2 and area=?3 and orderStatus='是'")
    int countsum2(Date startDate,Date finallyDate,String area);

}
