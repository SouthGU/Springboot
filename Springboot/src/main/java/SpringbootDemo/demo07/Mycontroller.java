//package SpringbootDemo.demo07;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Auther: sise.xgl
// * @Date: 2019/10/30/16:33
// * @Description:
// */
//
//@RestController
//public class Mycontroller {
//
//    @RequestMapping("/springboot")
//    public String security(){
//        return "hello world no security";
//    }
//
//    @PreAuthorize("hasRole('ROLE_DBM')")
//    @RequestMapping("/")
//    public String authorize(){
//        return "must security";
//    }
//
//    @RequestMapping("/hello/springboot")
//    public String hello(){
//        return "hello world must security";
//    }
//}
