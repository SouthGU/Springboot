//package SpringbootDemo.demo08;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
///**
// * @Auther: sise.xgl
// * @Date: 2019/11/6/16:35
// * @Description:
// */
//
//@Entity
//@Table(name="tb_user1")
//public class FKUser implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "login_name")
//    private String loginName;
//    private String username;
//    private String password;
//
//    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
//    @JoinTable(name = "tb_user_role",
//    joinColumns = {@JoinColumn(name = "user_id")},
//    inverseJoinColumns = {@JoinColumn(name = "role_id")})
//    private List<FKRole> roles;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public List<FKRole> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<FKRole> roles) {
//        this.roles = roles;
//    }
//}
