package SpringbootDemo.demo03_05;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserService02 {
    //第三周的作业
    @Resource
    private  UserRepository userRepository;
    @Transactional
    public User save(User user){
        return  userRepository.save(user);
    }
    public User findById(String id){
        return  userRepository.findById(id).get();
    }

    //第四周的作业---切记注入@Resource
    @Resource
    private UserPSrepository userPSrepository;
    public  Iterable<User> finaAllSort(Sort sort){
        return  userPSrepository.findAll(sort);
    }

}
