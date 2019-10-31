package SpringbootDemo.demo06;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/10:55
 * @Description:
 */
@Service
public class UserService_demo01 {
    @Resource
    private UserRepository_demo06_01 userRepository_demo06_01;

    @Transactional
    public void save(User user){
        userRepository_demo06_01.save(user);
    }
    public User selectByKey(String uid){
        return userRepository_demo06_01.findById(uid).get();
    }
}
