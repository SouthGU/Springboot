package SpringbootDemo.PageTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/25/23:40
 * @Description:
 */
@Controller
public class PageTest {

    @RequestMapping(value = "PageTest")
    public String PageTest(){
        return "PageTest2";
        //return "PageTest --> 更换";
    }
}
