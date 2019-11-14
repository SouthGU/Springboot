package SpringbootDemo.demo08_2;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/6/18:48
 * @Description:
 */

/**页面请求：
 *         /allproducts 浏览商品请求
 * 	       /order 下订单请求
 *         /sysadmin 系统管理请求
 *
 *         1、所有用户都可以浏览商品页；
 *         2、只有新用户和VIP用户可以进入下订单页面；
 *         3、只有网站管理员可以进入后台管理页面；
 *         4、新用户享受折扣：九折；VIP用户享受八折；其它用户不享受折扣。
 */
@RestController
public class Mycontroller1 {
        @RequestMapping("/allproducts")
        public String security(){
            return "所有用户都可以浏览商品页";
        }

        //@PreAuthorize("hasRole('ROLE_USER')")
        @PreAuthorize("hasAnyRole('ROLE_NEWUSER','ROLE_VIPUSER')")
        @RequestMapping("/")
        public String authorize(Authentication authentication) {

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            //System.out.println(authorities);
            //Object[] objects = authorities.toArray();
            //System.out.println(objects.equals("ROLE_USER"));
            //System.out.println(objects[0]);
            String test =authentication.getAuthorities().toString();
            System.out.println(test+"-------------------------------");
            for (GrantedAuthority authority : authorities) {

                    if (authority.getAuthority().equals("ROLE_NEWUSER")) {
                        return "新用户新用户新用户新用户新用户享受折扣：九折；" + authentication.getName();
                    } else if (authority.getAuthority().equals("ROLE_VIPUSER")) {

                        return "VIPVIPVIPVIPVIPVIPVIP用户享受八折； " + authentication.getName();
                    }
                    return "查询到了";
                    }

            return "查询有误";
            }

        @RequestMapping("/sysadmin")
        public String hello(Authentication authentication){

            return "只有网站管理员可以进入后台管理页面： "+authentication.getName();
        }
    }
