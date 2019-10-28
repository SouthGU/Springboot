package SpringbootDemo.demo03_05;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //第三周
    @Resource
    private UserService02 userService02;
    @RequestMapping(value = "/login")
    public String hello(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String doSave(@ModelAttribute User user , HttpSession session){
        user.setUsername(user.getUsername().toUpperCase());
        session.setAttribute("user",user);
        userService02.save(user);
        return "r";
    }

    @RequestMapping(value = "/find")
    public  String findById(@RequestParam(value = "uid",required = true) String uid,HttpSession session){

        User user = userService02.findById(uid);
        session.setAttribute("user",user);
        return "s";
    }

    //第四周
    @RequestMapping(value = "/sort")
    public String sortUser(HttpSession session){
        Sort sort = new Sort(Sort.Direction.DESC,"uid");
        Iterable<User> UserDatas = userService02.finaAllSort(sort);
        session.setAttribute("sort",UserDatas);
        return "soft";
    }


}
