package com.pionware.starter.spring5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerTimeLoggingInterceptor extends HandlerInterceptorAdapter {
	@Override 
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception { 
		request.setAttribute( 
				"startTime", System.currentTimeMillis()); 
		return true; 
	}

	@Override 
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception { 
		request.setAttribute( 
				"endTime", System.currentTimeMillis()); 
	}

	@Override 
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex) 
					throws Exception { 
		Long startTime = (Long) request.getAttribute("startTime"); 
		Long endTime = (Long) request.getAttribute("endTime");
		if(startTime != null && endTime != null)
			System.out.println(request.getRequestURL() + " -  time spent in ms : "  
				+ (endTime - startTime)); 
	}    
}
