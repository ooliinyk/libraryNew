package com.service;

import com.entity.Role;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17.03.2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
//        (user.getLogin(), user.getPassword(),
//                true, true, true, getGrantedAuthorities(user));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),true,
                true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Role role : user.getRoles()){
            System.out.println("UserProfile : "+role);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}
