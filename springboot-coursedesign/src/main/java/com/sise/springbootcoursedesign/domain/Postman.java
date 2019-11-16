package com.sise.springbootcoursedesign.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/16/9:43
 * @Description:
 */
@Entity
@Table(name = "postman")
public class Postman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;             //快递编号

    private String postmanName;    //快递员账号名称
    private String password;    //快递员账号密码

    private int getGoodsTotal;  //收件量
    private int outGoodsTotal;  //派件量
    private int basicPay;       //每月基本工资
    private int salary;         //每月总工资
    private int workDays;       //工作天数
    private int leaveDays;      //请假天数
    private int overtimeDays;   //加班天数

    private Date date;          //时间：用于签到、请假、加班时记录

    private String area;        //快递员所属区域

    @OneToMany(targetEntity = Post.class,mappedBy = "postman")
    Set<Post> posts = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostmanName() {
        return postmanName;
    }

    public void setPostmanName(String postmanName) {
        this.postmanName = postmanName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGetGoodsTotal() {
        return getGoodsTotal;
    }

    public void setGetGoodsTotal(int getGoodsTotal) {
        this.getGoodsTotal = getGoodsTotal;
    }

    public int getOutGoodsTotal() {
        return outGoodsTotal;
    }

    public void setOutGoodsTotal(int outGoodsTotal) {
        this.outGoodsTotal = outGoodsTotal;
    }

    public int getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(int basicPay) {
        this.basicPay = basicPay;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public int getOvertimeDays() {
        return overtimeDays;
    }

    public void setOvertimeDays(int overtimeDays) {
        this.overtimeDays = overtimeDays;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
