package SpringbootDemo.Quick;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickController {

    @RequestMapping("/page")
    @ResponseBody
    public String quick(){
        return "Springboot-->热部署完毕";
    }
}
