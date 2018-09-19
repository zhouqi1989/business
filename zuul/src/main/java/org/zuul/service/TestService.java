package org.zuul.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zuul.dao.ESDao;
import org.zuul.repository.AccountRepository;

@Service
public class TestService {
	
	//@Autowired
	public ESDao esDao;
	
	@Autowired
	public AccountRepository accountRepository;
	
	public void test() {
		
	}
	
	public void downloadFileZip(HttpServletRequest request,HttpServletResponse response) {
	}
}
