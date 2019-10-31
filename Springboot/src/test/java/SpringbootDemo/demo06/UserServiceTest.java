package SpringbootDemo.demo06;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/10:54
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService_demo01 userService;

    @Test
    public void find() throws Exception{
        User user = userService.selectByKey("9077");
        Assert.assertThat(user.getUsername(), CoreMatchers.is("ACAC"));
    }
}
