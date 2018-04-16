package com.pionware.starter.spring5.webxml;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.pionware.starter.spring5.context.SpringContextConfig;
import com.pionware.starter.spring5.dispatcher.SpringDispatcherConfig;

/**
 * This class implements the WebApplicationInitializer. It is invoked automatically during startup
 * given the spring-web jar is in the classpath. Moroever the automatic detection takes place 
 * only in Servlet 3.0++ containers and via the SpringServletContainerInitializer class (being bootstrapped via the container).
 * NOTE: this is a general mechanism for loading programmatically web resources (servlets, filters etc) accordingly to Servlet 3.0 spec
 * and not exclusively spring components. 
 * @author vnik
 *
 */
public class SpringWebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		addRootContext(container);
		addDispatcherContext(container); // it is also a child context that inherits from root
	}

	private void addRootContext(ServletContext container) {
		// Create the application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringContextConfig.class); 
	
		// Register application context with ContextLoaderListener
		container.addListener(new ContextLoaderListener(rootContext));
	}

	private void addDispatcherContext(ServletContext container) {
		// Create the dispatcher servlet's Spring application context for views
		AnnotationConfigWebApplicationContext viewDispatcherContext = new AnnotationConfigWebApplicationContext();
		viewDispatcherContext.register(SpringDispatcherConfig.class); 

		// Declare  <servlet> and <servlet-mapping> for the DispatcherServlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("app-servlet", 
				new DispatcherServlet(viewDispatcherContext));
		dispatcher.addMapping("*.html");
		dispatcher.addMapping("/resources/*");
		dispatcher.addMapping("/api/*");
		dispatcher.setLoadOnStartup(1);
		
		dispatcher.setMultipartConfig(getMultipartConfigElement());
		
		//container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
        //	.addMappingForUrlPatterns(null, false, "*.html", "/resources/*");		
	}
	
    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        return multipartConfigElement;
    }	
    
    private static final String LOCATION = ""; // Temporary location where files will be stored
    
    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
                                                        // Beyond that size spring will throw exception.
    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
     
    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk    

}
