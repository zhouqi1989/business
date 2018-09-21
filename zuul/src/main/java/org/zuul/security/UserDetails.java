package org.zuul.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.zuul.entity.Account;
import org.zuul.repository.AccountRepository;

@Component
public class UserDetails implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		List<Account> accountList = accountRepository.findByAccount(username);
		
		if(accountList!=null&&!accountList.isEmpty())
			return accountRepository.findByAccount(username).get(0);
		
		return null;
	}

}
