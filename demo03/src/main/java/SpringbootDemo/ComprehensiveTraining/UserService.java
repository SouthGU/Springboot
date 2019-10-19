package SpringbootDemo.ComprehensiveTraining;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    @Resource
    private EmployeeRepository employeeRepository;
    @Resource
    private DepartRepository departRepository;

    /**
      * 描述一下方法的作用
      * @Author: COM.SISE.XGL
      * @Date: 2019/10/20 0:44
      * @param dname
      * @param age
      * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
      * @Description:
    **/
    public List<Map<String,Object>> getIdAndNameBydepartNameAndAge(String dname,int age){
        List<Employee> es = employeeRepository.findIdAndNameByDepartNameAndAge(dname,age);
        List<Map<String,Object>> results = new ArrayList<>();
        for (Employee e:es){
            Map<String,Object> m = new HashMap<>();
            m.put("id",e.getId());
            m.put("name",e.getName());
            m.put("age",e.getAge());
            results.add(m);
        }
        return results;
    }

    public List<String> getDepartNameByEmployeeName(String employeeName){
        return employeeRepository.findDepartNameByEmployeeName(employeeName);
    }

    @Transactional
    public int deleteEmployeeByName(String employeeName){
        return employeeRepository.deleteEmployeeByEmployyName(employeeName);
    }
    @Transactional
    public int queryEmployeeByName(String employeeName){
        return employeeRepository.queryEmployeeByName(employeeName);
    }

}
