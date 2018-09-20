package org.zuul.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class ZuulExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String handler(HttpServletRequest req, Exception e){
		String r="{'message':%s,'code':%d}";

        return r.format(r, e.getMessage(),500);
	}
}
