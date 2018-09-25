package org.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zuul.security.AuthenProvider;
import org.zuul.security.UserDetails;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter {

	@Autowired
	AuthenProvider authenProvider;
	
	@Autowired
	private UserDetails userDetails;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
        	.authorizeRequests()        
                .anyRequest()
                .authenticated();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }

	/*@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	    auth.authenticationProvider(authenProvider);
	    auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
	}
	
}
