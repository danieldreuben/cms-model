package com.ros.cms;

import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomFilter extends GenericFilterBean {

    @Override
    public void doFilter(
      ServletRequest request,
      ServletResponse response,

      FilterChain chain) throws IOException, ServletException {

        System.out.println("Filter>>");
        Authentication authentication = new UsernamePasswordAuthenticationToken("ADMIN", "test");
        //authentication.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }
}
