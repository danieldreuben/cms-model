package com.ros.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class UserDetailServiceImpl implements UserDetailsService  {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        System.out.println("loadUserByUsername : "+username);

        UserDetails user = new org.springframework.security.core.userdetails.User (
            username, "password", true, true, true, true, getAuthorities());
        //user.setRoles(Arrays.asList("ADMIN"));
        System.out.println("user : "+user);
        return user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
          List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
          list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
          list.add(new SimpleGrantedAuthority("ADMIN"));
          list.add(new SimpleGrantedAuthority("admin"));
          list.add(new SimpleGrantedAuthority("USER"));
          return list;
    }
}
