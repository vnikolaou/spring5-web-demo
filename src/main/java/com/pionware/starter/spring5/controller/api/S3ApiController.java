package com.pionware.starter.spring5.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pionware.starter.spring5.converter.DateEditor;
import com.pionware.starter.spring5.service.S3Service;

@Controller
public class S3ApiController {
	@Autowired
	private S3Service s3Service;
	
	@Autowired 
	private LocalValidatorFactoryBean validator; 
	@Autowired 
	private Validator bucketValidator;
	 
	public S3ApiController() {
		System.out.println("Creating API S3Controller...");
	}
	
    @RequestMapping(value = "/welcome") 
    @ResponseBody 
    public String welcome() { 
    	//Map map = new HashMap();
    	//map.put("firstname", "Vagelis");
    	//map.put("lastname", "Nikolaou");
    	return "Welcome Vag";
    } 
    
	
	@ModelAttribute("zones") 
	public List<String>availableZones() { 
		List<String> zones = new ArrayList<String>(); 
		zones.add("Zone1"); 
		zones.add("Zone2"); 
		return zones; 
	}	
	

	@InitBinder({"bucket"}) 
	private void initBinder(WebDataBinder webDataBinder) { 
	  webDataBinder.addValidators(bucketValidator); // add custom validator apart the basic ones from annotations
	  webDataBinder.registerCustomEditor(Date.class, new DateEditor()); 
	}	

}
