package com.pionware.starter.spring5.advice;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice 
public class ExceptionController {
	@ExceptionHandler(value = Exception.class) 
	public ModelAndView handleException(HttpServletRequest request, Exception ex) { 
		System.out.println("1.Request " + request.getRequestURL() + " Threw an Exception"); 
		
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("exception", ex.getMessage()); 
		mav.addObject("url", request.getRequestURL()); 
		mav.setViewName("error"); 
		
		return mav; 
	}
}
