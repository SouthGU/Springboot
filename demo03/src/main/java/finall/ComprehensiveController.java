package finall;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ComprehensiveController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/getIDAndNameByDepartNameAndAge")
    public String getIDAndNameByDepartNameAndAge(String dname, int age, HttpSession session){
        List<Map<String,Object>> em = userService.getIdAndNameBydepartNameAndAge(dname, age);
        System.out.println(dname);
        System.out.println("1111");
        System.out.println(em);
        session.setAttribute("employees",em);
        return "employee";
    }

    @RequestMapping(value = "/getDepatNameByEmployeeName")
    public String getDepartNameByEmployeeName(String employeeName,HttpSession session){
        String em = userService.getDepartNameByEmployeeName(employeeName);
        System.out.println(employeeName);
        System.out.println(em);
        session.setAttribute("depart",em);
        return "d";
    }

    @RequestMapping(value = "/deleteEmployeeByEmployeeName")
    public String deleteEmployeeByEmployeeName(String employeeName){
        int val = userService.deleteEmployeeByName(employeeName);
        System.out.println(val);
        return "delete";
    }
}
