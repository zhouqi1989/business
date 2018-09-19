package org.zuul.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SecurityFilter extends ZuulFilter  {

	@Override
	public Object run() {
		System.out.println("111111111111111111");
		
		RequestContext ct = RequestContext.getCurrentContext();
		ct.setSendZuulResponse(false);
		ct.setResponseStatusCode(404);
		ct.setResponseBody(ct.getRequest().getServletPath());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
}
