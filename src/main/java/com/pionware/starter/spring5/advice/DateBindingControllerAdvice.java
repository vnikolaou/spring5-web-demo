package com.pionware.starter.spring5.advice;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.pionware.starter.spring5.converter.DateEditor;

@ControllerAdvice 
public class DateBindingControllerAdvice { 
	@InitBinder 
	protected void initBinder(WebDataBinder webDataBinder) { 
		webDataBinder.registerCustomEditor(Date.class, new DateEditor());  
	}
	
	
}
