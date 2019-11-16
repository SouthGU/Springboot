package com.sise.springbootcoursedesign.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/15/23:35
 * @Description:
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String passWord;

    @OneToMany(targetEntity = Post.class,mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}