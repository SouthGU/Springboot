package SpringbootDemo.demo06;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/31/10:53
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBoot6ApplicationTests.class)
@Rollback(value = false) //spring boot单元测试默认会事务回滚，故此需要强制不回滚注解，@Rollback(false)
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @Transactional
    public void addUser()throws Exception{
        String json = "{\"uid\":\"9077\",\"username\":\"ACAC\",\"password\":\"1234\"}";
        mvc.perform(MockMvcRequestBuilders.post("/user/save")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(json.getBytes())
               )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void queryUser() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/user/get/9077")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("ACAC"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("1234"))
        .andDo(MockMvcResultHandlers.print());

    }
}
