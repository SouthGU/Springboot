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

    private int standardWorkload; //自定义标准工作量



    private String area;        //快递员所属区域

    @OneToMany(targetEntity = Post.class,mappedBy = "postman")
    Set<Post> posts = new HashSet<>();

    @OneToMany(targetEntity = PostmanDays.class,mappedBy = "postman2")
    Set<PostmanDays> postmandays = new HashSet<>();

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

    public Set<PostmanDays> getPostmandays() {
        return postmandays;
    }

    public void setPostmandays(Set<PostmanDays> postmandays) {
        this.postmandays = postmandays;
    }
    public int getStandardWorkload() {
        return standardWorkload;
    }

    public void setStandardWorkload(int standardWorkload) {
        this.standardWorkload = standardWorkload;
    }
}
