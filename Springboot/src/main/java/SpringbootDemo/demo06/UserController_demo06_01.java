package SpringbootDemo.demo06;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/10:57
 * @Description:
 */
@RestController
@RequestMapping("user")
public class UserController_demo06_01 {

    @Resource
    private UserService_demo01 userService_demo01;
    @PostMapping(value = "/save")
    public Map<String,Object> save(@RequestBody User user){ //@RequestBody注明接收json格式字符串
        userService_demo01.save(user);
        Map<String,Object> p = new HashMap<>();
        p.put("code","success");
        return p;
    }

    @GetMapping(value = "/get/{uid}")
    @ResponseBody
    public User selectUser(@PathVariable(value = "uid") String uid){
        User user = userService_demo01.selectByKey(uid);
        return user;
    }
}
