package SpringbootDemo.demo07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/30/16:25
 * @Description:
 */
@Repository
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //大课课件
/*
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(new MypasswordEncoder())
                .withUser("zy")
                .password("123456")
                .roles("USER");

        auth.inMemoryAuthentication().passwordEncoder(new MypasswordEncoder())
                .withUser("xgl")
                .password("123456")
                .roles("ADMIN","DBM");
    }
*/
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()  //配置安全策略
            .antMatchers("/springboot").permitAll() //定义/springboot请求不需要验证
            .antMatchers("/hello/**").hasRole("DBM")
            .anyRequest().authenticated() //其余所有的请求都需要通过验证
            .and()
        .logout()
            .permitAll()    //定义logout不需要验证
            .and()
        .formLogin();   //使用form表单登录
    }


    //小课课件
    //报错没关系，照样可以运行
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(name = "stringRedisTemplate")
        ValueOperations<String,String> valOpsStr;


    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 从Redis中取值，该方法的名称必须为configure
     * 名称会与大课课件冲突，一次只使用一个即可。
     * @param auth
     * @throws Exception
     */
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser(valOpsStr.get("user1")).password(passwordEncoder().encode(valOpsStr.get("password1"))).roles("USER");
        auth.inMemoryAuthentication().withUser(valOpsStr.get("user2")).password(passwordEncoder().encode(valOpsStr.get("password2"))).roles("ADMIN","DBM");
        //user3=xgl password3=123456
        auth.inMemoryAuthentication().withUser(valOpsStr.get("user3")).password(passwordEncoder().encode(valOpsStr.get("password3"))).roles("ADMIN","DBM");
    }


}
