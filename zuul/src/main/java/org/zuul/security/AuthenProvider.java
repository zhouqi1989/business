package org.zuul.security;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenProvider implements AuthenticationProvider,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 456987L;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetails userDetails;
	
	@Override
	public Authentication authenticate(Authentication authen) throws AuthenticationException {
		String name=(String)authen.getPrincipal();
		
		String passwrod = (String)authen.getCredentials();
		
		if(StringUtils.isBlank(name)||StringUtils.isBlank(passwrod))return null;
		
		org.springframework.security.core.userdetails.UserDetails user=userDetails.loadUserByUsername(name);
		
		if(!passwordEncoder.matches(passwrod,user.getPassword())){
			throw new BadCredentialsException("密码不正确");
		}
		
		return new UsernamePasswordAuthenticationToken(name,passwrod);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
