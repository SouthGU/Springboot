package com.sise.springbootcoursedesign.dao;

import com.sise.springbootcoursedesign.domain.Post;
import org.springframework.data.domain.Sort;
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


    /**
     * @date: 2019/11/25
     * @description: xgl
     */

    List<Post> findAllByOrderStatus(String OrderStatus);

    long countByOutGoodsStatusAndGetDateBetween(String outGoodsStatus, Date date1, Date date2);

    long countByGetGoodsFaultAndGetDateBetween(String getGoodsStatus, Date date1, Date date2);

    long countByOutGoodsFaultAndGetDateBetween(String outGoodsFault, Date date1, Date date2);

    @Query("select count(outGoodsStatus) from Post where outDate BETWEEN ?1 and ?2 and area=?3 and outGoodsStatus='派件签收'")
    int countsum1(Date startDate,Date finallyDate,String area);

    @Query("SELECT count(orderStatus) from Post where getDate BETWEEN ?1 and ?2 and area=?3 and getGoodsStatus='收件成功'")
    int countsum2(Date startDate,Date finallyDate,String area);

    @Query("SELECT count(orderStatus) FROM Post where getDate BETWEEN  ?1 and ?2 AND postman.id = ?3 and area=?4 and getGoodsStatus='收件成功'")
    int countOrderStatusPost(Date startdate,Date finallydate,int id,String area);

    @Query("SELECT count(outGoodsStatus) FROM Post where getDate BETWEEN  ?1 and ?2 AND postman.id = ?3 and area=?4 and outGoodsStatus ='派件签收'")
    int countOutGoodsStatus(Date startdate, Date finallydate, int id, String area);

    @Query("select COUNT(orderStatus) FROM Post where getGoodsStatus='收件成功' and getDate between ?1 and ?2")
    int countGetPost(Date startdate2, Date finallydate2);

    @Query("select COUNT(outGoodsStatus) FROM Post where outGoodsStatus='派件签收' and outDate between ?1 and ?2 ")
    int countOutPost(Date startdate2, Date finallydate2);

    //派件故障数
    @Query("select COUNT(outGoodsFault) FROM Post where outGoodsFault='是' and outDate between ?1 and ?2 ")
    int countFailPost(Date startdate2, Date finallydate2);

    //收件故障数
    @Query("select COUNT(getGoodsFault) FROM Post where getGoodsFault='是' and getDate between ?1 and ?2 ")
    int countFailPost2(Date startdate3, Date finallydate3);

    @Query("select distinct area FROM Post")
    List<String> areaArray();


    /**
     * @date: 2019/11/25
     * @description: wxy
     */

    Iterable<Post> findByTargetAddressLike(Sort sort, String targetAddress);

    @Query(nativeQuery = true, value = "SELECT * FROM post WHERE PERIOD_DIFF(DATE_FORMAT(NOW(), '%Y%m'), DATE_FORMAT(get_date, '%Y%m')) = 1 AND postman_id = ?1")
    List<Post> findLastMonthWorkload(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM post WHERE postman_id = ?1 ORDER BY out_goods_number ASC")
    Iterable<Post> findAllPostByPostmanId(int pno);

}
