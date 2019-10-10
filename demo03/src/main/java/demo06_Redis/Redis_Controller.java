package demo06_Redis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class Redis_Controller {
    @Resource
    private UserRedisDAO userRedisDAO;

    @RequestMapping(value = "/getStringByRedis")
    public String getStrByRedis(HttpSession session){
        String s = userRedisDAO.getStringByRedis();
        session.setAttribute("redis",s);
        return "redis";
    }
    @RequestMapping(value = "/insertUserByRedis")
    public String insertUserByRedis(String uid,String username,String password){
            demo06_Redis.User user = new demo06_Redis.User(uid,username,password);
            userRedisDAO.insertUserByRedis(user);
            return "insert";
    }
    @RequestMapping(value = "findUserByRedis")
    public String selectUserByRedis(String uid,HttpSession session){
        User user = userRedisDAO.findUserByRedis(uid);
        session.setAttribute("user",user);
        return "s";
    }
}
