package SpringbootDemo.demo06;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/10:48
 * @Description:
 */
@Entity
@Table(name="stu")
public class User implements java.io.Serializable{
    String uid;
    String username;
    String password;



    public User() {
    }

    public User(String uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    @Id
    @GenericGenerator(name = "session_info_uuid_gen",strategy = "assigned")
    @GeneratedValue(generator = "session_info_uuid_gen")
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
