package SpringbootDemo.demo06.demo02;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/11:44
 * @Description:
 */
@Service
public class UserService_demo02 {

    @Resource
    private EmployeeRepository_demo06_02 employeeRepository_demo06_02;
    @Resource
    private DepartRepository_demo06_02 departRepository_demo06_02;

    public List<Map<String,Object>> getEmployeeByDepartName(String dname){
        List<Employee_demo06_02> es = employeeRepository_demo06_02.findByDepart_DepartName(dname);
        List<Map<String,Object>> results = new ArrayList<>();
        for(Employee_demo06_02 e : es){
            Map<String,Object> m = new HashMap<>();
            m.put("id",e.getId());
            m.put("name",e.getName());
            m.put("age",e.getAge());
            results.add(m);
        }
        return results;
    }
}
