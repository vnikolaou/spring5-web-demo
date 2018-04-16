package com.pionware.starter.spring5.controller.view;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.pionware.starter.spring5.controller.api.S3ApiController;
import com.pionware.starter.spring5.service.S3Service;

public class S3ViewControllerTest {
	private MockMvc mockMvc; 
	
	@Before 
	public void setup() { 
		this.mockMvc = MockMvcBuilders.standaloneSetup 
				(new S3ViewController()) 
				.setViewResolvers(viewResolver()).build(); 		
	} 

	private ViewResolver viewResolver() { 
		InternalResourceViewResolver viewResolver =  
				new InternalResourceViewResolver(); 
		viewResolver.setViewClass(JstlView.class); 
		viewResolver.setPrefix("/WEB-INF/jsp/"); 
		viewResolver.setSuffix(".jsp"); 
		return viewResolver; 
	} 
    
	/*
	@Test 
	public void testBucketListView() throws Exception { 
		this.mockMvc 
		.perform(get("/buckets.html") 
				.accept(MediaType.parseMediaType( 
						"application/html;charset=UTF-8"))) 
		.andExpect(model().attribute("author", "Vagelis Nikolaou")); 
		.andExpect(view().name("buckets")); 
	} */   
}
