package SpringbootDemo.demo07;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/30/16:25
 * @Description:
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
}
