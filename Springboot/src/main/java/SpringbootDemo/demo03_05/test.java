package SpringbootDemo.demo03_05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

    @RequestMapping(value = "hello")
    public String test(){
        return  "test";
    }
}
