//package SpringbootDemo.demo08;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * @Auther: sise.xgl
// * @Date: 2019/11/6/16:32
// * @Description:
// */
//
//@Entity
//@Table(name="tb_role")
//public class FKRole implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private Long id;
//    @Column(name = "authority")
//    private String authority;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//}
