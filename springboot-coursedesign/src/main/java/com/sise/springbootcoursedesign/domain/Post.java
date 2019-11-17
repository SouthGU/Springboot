package com.sise.springbootcoursedesign.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/15/23:52
 * @Description:
 */
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String houseAddress;    //自家地址
    private String targetAddress;   //快递目标地址
    private String phone;           //电话
    private String area;            //快递所属区域
    private String orderStatus;     //是否有快递员接此单：是、否


    private String getGoodsStatus;  //收件状态：准备收件、成功或失败
    private String failGetGoodsReason;  //收件失败原因
    private String getGoodsFault;       //收件故障：是或否
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date getDate;           //收件时间

    private String outGoodsStatus;  //派件状态：准备派件、正在派件、派件签收、没成功签收
    private int outGoodsNumber; //派件次数
    private String failOutGoodsReason;  //派件失败原因
    private String outGoodsFault;       //派件故障：是或否
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date outDate;           //派件时间


    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Postman.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "postman_id",referencedColumnName = "id")
    private Postman postman;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getGetGoodsStatus() {
        return getGoodsStatus;
    }

    public void setGetGoodsStatus(String getGoodsStatus) {
        this.getGoodsStatus = getGoodsStatus;
    }

    public String getFailGetGoodsReason() {
        return failGetGoodsReason;
    }

    public void setFailGetGoodsReason(String failGetGoodsReason) {
        this.failGetGoodsReason = failGetGoodsReason;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public String getOutGoodsStatus() {
        return outGoodsStatus;
    }

    public void setOutGoodsStatus(String outGoodsStatus) {
        this.outGoodsStatus = outGoodsStatus;
    }

    public int getOutGoodsNumber() {
        return outGoodsNumber;
    }

    public void setOutGoodsNumber(int outGoodsNumber) {
        this.outGoodsNumber = outGoodsNumber;
    }

    public String getFailOutGoodsReason() {
        return failOutGoodsReason;
    }

    public void setFailOutGoodsReason(String failOutGoodsReason) {
        this.failOutGoodsReason = failOutGoodsReason;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Postman getPostman() {
        return postman;
    }

    public void setPostman(Postman postman) {
        this.postman = postman;
    }

    public String getGetGoodsFault() {
        return getGoodsFault;
    }

    public String getOutGoodsFault() {
        return outGoodsFault;
    }

    public void setOutGoodsFault(String outGoodsFault) {
        this.outGoodsFault = outGoodsFault;
    }

    public void setGetGoodsFault(String getGoodsFault) {
        this.getGoodsFault = getGoodsFault;
    }
}
