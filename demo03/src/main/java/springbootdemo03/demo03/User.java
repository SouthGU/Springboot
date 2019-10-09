package springbootdemo03.demo03;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="stu")
public class User {
    String uid;
    String username;
    String password;
    public User(){};
    public void setUid(String s){
        uid = s ;
    }

    @Id
    @GenericGenerator(name="session_info_uuid_gen",strategy = "assigned")
    @GeneratedValue(generator = "session_info_uuid_gen")
    @Column(name="uid")
    public String getUid(){
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
