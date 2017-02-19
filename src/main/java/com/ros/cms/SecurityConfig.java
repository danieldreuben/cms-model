
package com.ros.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author
 */
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(
				 new CustomFilter(), BasicAuthenticationFilter.class);
		http
				.authorizeRequests()
					.antMatchers("/message/**","/about").permitAll()
				  .antMatchers("/jersey/order/**", "/jersey/orders/**").access("hasAuthority('ADMIN')")
				  .antMatchers("/jersey/orders/**").access("hasRole('SUPER')");

					//.antMatchers("/jersey/order/**", "/jersey/orders/**").access("isAuthenticated()");

	}

	 /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				//auth.authenticationProvider(new CustomAuthenticationProvider());
				System.out.println("configure..");
			  auth.userDetailsService(new UserDetailServiceImpl());
    }*/

		 @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			   auth.authenticationProvider(new CustomAuthenticationProvider());

         //auth.userDetailsService(userDetailsServiceBean());
     }

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}*/
}
