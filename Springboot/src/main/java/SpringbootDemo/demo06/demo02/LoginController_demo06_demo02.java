package SpringbootDemo.demo06.demo02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/11:49
 * @Description:
 */
@RestController
public class LoginController_demo06_demo02 {

    @Resource
    private UserService_demo02 userService_demo02;

    @GetMapping(value = "/getDepartEmployee/{dname}")
    public List<Map<String,Object>> getDepartEmployee(@PathVariable(value = "dname") String dname){
        List<Map<String,Object>> em = userService_demo02.getEmployeeByDepartName(dname);
        return em;
    }
}
