package com.pionware.starter.spring5.context;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = {"com.pionware.starter.spring5.service", "com.pionware.starter.spring5.validator"})
public class SpringContextConfig {
	public SpringContextConfig() {
		System.out.println("Creating SpringContextConfig...");
	}	
	

	// needed in spring5; the @Valid does not work with JSR303/349 validation annotations any more
	@Bean 
	public LocalValidatorFactoryBean validator(){ 
	    return new LocalValidatorFactoryBean(); 
	} 	
	

}
