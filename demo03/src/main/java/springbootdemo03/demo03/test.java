package springbootdemo03.demo03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class test {

    @RequestMapping(value = "hello")
    public String test(){
        return  "test";
    }
}
