package com.pionware.starter.spring5.dispatcher;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.theme.SessionThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.pionware.starter.spring5.interceptor.CustomLocaleChangeInterceptor;
import com.pionware.starter.spring5.interceptor.HandlerTimeLoggingInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {/*"com.pionware.starter.spring5.security",*/"com.pionware.starter.spring5.controller", "com.pionware.starter.spring5.advice"})
public class SpringDispatcherConfig extends WebMvcConfigurerAdapter {
	
	public SpringDispatcherConfig() {
		System.out.println("Creating SpringViewDispatcherConfig...");
	}
	
	@Bean 
	public LocalValidatorFactoryBean validator(){ 
	    return new LocalValidatorFactoryBean(); 
	} 	

    
	@Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolverA = new InternalResourceViewResolver();
        viewResolverA.setPrefix("/WEB-INF/jsp/");
        viewResolverA.setSuffix(".jsp");
        viewResolverA.setOrder(1);
        return viewResolverA;
    }

    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) { 
      registry 
     .addResourceHandler("/static/**") // logical  (if spring servlet accepts maps static content to /resources/* then static will be in the /resources/static URI)
     .addResourceLocations("/static/") // physical
     .setCachePeriod(365 * 24 * 60 * 60) // this doesn't send always a header Cache-Control (only the first time that sends the file)
     .resourceChain(true) 
     .addResolver(new GzipResourceResolver()) // this doesn't seem to work always as expected (there is no Content-Encoding: gzip in response) 
     .addResolver(new PathResourceResolver());   // default resolvers   
      
      registry 
     .addResourceHandler("/webjars/**") // logical
     .addResourceLocations("/webjars/"); // physical      

    } 

    @Bean
    public ThemeSource themeSource() {
    	ResourceBundleThemeSource source = new ResourceBundleThemeSource();
    	source.setBasenamePrefix("app-");
    	return source;
    }
    @Bean 
    public ThemeResolver themeResolver(){
    	SessionThemeResolver resolver = new SessionThemeResolver();
    	resolver.setDefaultThemeName("theme1");
    	return resolver;
    }
    
	/// NOTE: it is enabled only if @EnableWebMvc is present in this class
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("Creating interceptors");
	    registry.addInterceptor(new HandlerTimeLoggingInterceptor());
	    
	    LocaleChangeInterceptor localeChangeInterceptor = new CustomLocaleChangeInterceptor();
	    localeChangeInterceptor.setParamName("language");	  
	    registry.addInterceptor(localeChangeInterceptor);
	    
		//Theme specific
		ThemeChangeInterceptor themeInterceptor = new ThemeChangeInterceptor();
		themeInterceptor.setParamName("theme");
		registry.addInterceptor(themeInterceptor);	    
	}	
	
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }
    
	@Bean
	public MessageSource messageSource()  {
		System.out.println("Creating messageSource");
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames("classpath:config/messages", "classpath:config/errors");
	    messageSource.setUseCodeAsDefaultMessage(true);
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(10); // this is not good for production; switch to -1
	    return messageSource;
	}	
	
	@Bean(name="multipartResolver")
    public StandardServletMultipartResolver resolver() {
        return new StandardServletMultipartResolver();
    }	
}
