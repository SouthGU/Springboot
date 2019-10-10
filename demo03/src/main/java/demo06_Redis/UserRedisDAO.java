package demo06_Redis;

import demo06_Redis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserRedisDAO {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valOps;

    public  void setStringRedisTemplateDemo(){
        valOpsStr.set("hello","Spring boot Redis");
    }

    public String getStringByRedis(){
        return valOpsStr.get("hello");
    }

    public void insertUserByRedis(demo06_Redis.User user){
        valOps.set(user.getUid(),user);
    }
    public demo06_Redis.User findUserByRedis(String uid){
        return  (User)valOps.get(uid);
    }

}
