package com.pionware.starter.spring5.advice;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice(annotations=(SessionAttributes.class))
public class ModelAttributeControllerAdvice {
	@ModelAttribute("dummy") 
	public String dummy() { 
		return "Hi Vagelis"; 
	}	
	
	

}
