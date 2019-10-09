package springbootdemo03.demo03;

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
    private  UserService userService;
    @RequestMapping(value = "/login")
    public String hello(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String doSave(@ModelAttribute User user , HttpSession session){
        user.setUsername(user.getUsername().toUpperCase());
        session.setAttribute("user",user);
        userService.save(user);
        return "r";
    }

    @RequestMapping(value = "/find")
    public  String findById(@RequestParam(value = "uid",required = true) String uid,HttpSession session){

        User user = userService.findById(uid);
        session.setAttribute("user",user);
        return "s";
    }

    //第四周
    @RequestMapping(value = "/sort")
    public String sortUser(HttpSession session){
        Sort sort = new Sort(Sort.Direction.DESC,"uid");
        Iterable<User> UserDatas = userService.finaAllSort(sort);
        session.setAttribute("sort",UserDatas);
        return "soft";
    }
}
