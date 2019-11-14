package SpringbootDemo.demo08_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: sise.xgl
 * @Date: 2019/11/6/16:41
 * @Description:
 */

@Service
public class User11Service implements UserDetailsService {

    @Autowired
    User1Repository user1Repository;

    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException{
        FKUser fkUser  = user1Repository.findByLoginName(username);
        if(fkUser==null)
            throw new UsernameNotFoundException("用户名不存在");
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<FKRole> roles = fkUser.getRoles();
        for(FKRole role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return new User(fkUser.getUsername(),fkUser.getPassword(),authorities);
    }



    public Collection<? extends GrantedAuthority> getUserAuthorities() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return authorities;
    }

}
