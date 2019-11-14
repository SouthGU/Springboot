//package SpringbootDemo.demo08;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Auther: sise.xgl
// * @Date: 2019/11/6/18:48
// * @Description:
// */
//@RestController
//public class Mycontroller1 {
//
//    @RequestMapping("/springboot")
//    public String security(){
//        return "hello world no security";
//    }
//
//    @PreAuthorize("hasRole('ROLE_DBM')")
//    @RequestMapping("/")
//    public String authorize(Authentication authentication){
//        return "must security "+authentication.getName();
//    }
//
//    @RequestMapping("/hello/springboot")
//    public String hello(Authentication authentication){
//        return "hello world must security"+authentication.getName();
//    }
//}
