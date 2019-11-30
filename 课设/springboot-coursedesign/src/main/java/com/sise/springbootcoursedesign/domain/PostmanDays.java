package com.sise.springbootcoursedesign.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/17/0:22
 * @Description:
 */
@Entity
@Table(name = "postdays")
public class PostmanDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int workDays;       //工作天数
    private int leaveDays;      //请假天数
    private int overtimeDays;   //加班天数
    private Date date;          //时间：用于签到、请假、加班时记录

    @ManyToOne(targetEntity = Postman.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "postman_id",referencedColumnName = "id")
    private Postman postman2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Postman getPostman2() {
        return postman2;
    }

    public void setPostman2(Postman postman2) {
        this.postman2 = postman2;
    }
}

