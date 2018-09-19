package org.zuul.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zuul.service.TestService;

@RestController
@RequestMapping("/")
public class TestController{
	
	@Autowired
	TestService testService;
	
	//@EventListener(classes = RemoteApplicationEvent.class)
	//@RepositoryRestController
	@RequestMapping("aa.zhouqi")
	public String test() {
		System.out.println("22222222fdsafds");
		return "aaaaa";
	}
	
	@RequestMapping(value = "/downloadFileZip.do", method = RequestMethod.POST)
	public void downloadFileZip(@RequestBody String body, HttpServletRequest request,HttpServletResponse response) {
		testService.downloadFileZip(request, response);
	}
}
