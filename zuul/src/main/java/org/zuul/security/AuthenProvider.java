package org.zuul.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.zuul.entity.Account;

@Component
public class AuthenProvider implements AuthenticationProvider {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authen) throws AuthenticationException {
		String passwrod=(String)authen.getPrincipal();
		
		Account user = (Account)authen.getDetails();
		
		String encoderPassword=bCryptPasswordEncoder.encode(passwrod);
		if(user.getPassword().equals(encoderPassword)){
			
		}else{
			throw new BadCredentialsException("密码不正确");
		}
		
		return new UsernamePasswordAuthenticationToken(authen.getPrincipal(), 
				user, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
