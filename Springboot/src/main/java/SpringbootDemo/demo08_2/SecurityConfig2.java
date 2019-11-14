package SpringbootDemo.demo08_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/6/18:38
 * @Description:
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig2 extends WebSecurityConfigurerAdapter {

    @Resource
    private User11Service user11Service;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(user11Service);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider);
    }

    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()  //配置安全策略
                .antMatchers("/allproducts").permitAll() //定义/allproducts请求不需要验证
                .antMatchers("/order").hasAnyRole("USER","VIPUSER")
                .antMatchers("/sysadmin").hasRole("ADMIN")
                .anyRequest().authenticated() //其余所有的请求都需要通过验证
                .and()
                .logout()
                .permitAll()    //定义logout不需要验证
                .and()
                .formLogin();   //使用form表单登录
    }
}
