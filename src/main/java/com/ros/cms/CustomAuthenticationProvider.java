package com.ros.cms;

import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.io.IOException;
import javax.servlet.ServletException;

@Component
public class CustomAuthenticationProvider
  implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
      throws AuthenticationException {
        UsernamePasswordAuthenticationToken token =
          new UsernamePasswordAuthenticationToken(
              authentication.getName(), authentication.getCredentials().toString(),
                getAuthorities());
        System.out.println("CustomAuthenticationProvider-"+ token.getName() +
          " Authorities : "+ token.getAuthorities());
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
          List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
          list.add(new SimpleGrantedAuthority("ADMIN"));
          list.add(new SimpleGrantedAuthority("USER"));
          list.add(new SimpleGrantedAuthority("ROLE_SUPER"));

          return list;
    }
   
}
