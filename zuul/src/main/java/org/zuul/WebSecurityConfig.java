package org.zuul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    
                .and()
                .authorizeRequests()        
                .anyRequest()              
                .authenticated();
    }
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        /*auth.inMemoryAuthentication().withUser("admin")
        	.password("admin")
        	.roles("adminstrator"); */  
    }
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }
	
}
