package SpringbootDemo.ComprehensiveTraining;


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
        session.setAttribute("employees",em);
        return "employee";

    }

    @RequestMapping(value = "/getDepatNameByEmployeeName")
    public String getDepartNameByEmployeeName(String employeeName,HttpSession session){
        List<String> em = userService.getDepartNameByEmployeeName(employeeName);
        System.out.println(employeeName);
        System.out.println(em);
        session.setAttribute("depart",em);
        session.setAttribute("employeeName",employeeName);
        return "d";
    }

    @RequestMapping(value = "/deleteEmployeeByEmployeeName")
    public String deleteEmployeeByEmployeeName(String employeeName,HttpSession session){
        int va =userService.queryEmployeeByName(employeeName);
        if(va>=1){
            int val = userService.deleteEmployeeByName(employeeName);
            System.out.println(val);
            session.setAttribute("depart","删除成功");
        } else{
            session.setAttribute("depart","对不起，没有此用户");
        }
        return "delete";
    }
}
