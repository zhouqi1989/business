package org.zuul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zuul.handler.AccountHandler;

//@EnableWebSecurity
@Configuration
public class WebSecurityConfig {//extends WebSecurityConfigurerAdapter {

	/*@Override
    protected void configure(HttpSecurity http) throws Exception {
        //表示所有的访问都必须进行认证请求处理后才能正常进行
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
        //设置session为无状态,提升操作效率
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    
	}
	
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("jmxjava").password("jmxhello").roles("USER").and().withUser("admin").password("admin").roles("adminstrator");   
    }*/
	
	@Bean
	AccountHandler accountEventHandler() {
		
		return new AccountHandler();
	}
	
}
