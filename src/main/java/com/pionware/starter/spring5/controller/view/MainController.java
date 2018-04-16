package com.pionware.starter.spring5.controller.view;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ThemeResolver;

@Controller
public class MainController {
	public MainController() {
		System.out.println("Creating MainController...");
	}
	@GetMapping("/index.html")
	public String index(WebRequest wrequest, HttpServletRequest request, SessionStatus status, Model model,  Locale locale) {


        FormData formData = new FormData();
        formData.setLanguage(locale.toString());
 
        formData.setTheme((String)request.getSession().getAttribute("org.springframework.web.servlet.theme.SessionThemeResolver.THEME"));

        model.addAttribute("formData", formData);
        
	    status.setComplete(); // this marks the session process as complete
	    wrequest.removeAttribute("author",
	      WebRequest.SCOPE_SESSION); 
	    
		return "index";
	}
	
	@PostMapping("/index.html")
	public String index(HttpServletRequest request,Model model,  Locale locale) {
        FormData formData = new FormData();
        formData.setLanguage(locale.toString());
        HttpSession session = request.getSession();
      
        formData.setTheme((String)session.getAttribute("org.springframework.web.servlet.theme.SessionThemeResolver.THEME"));

        model.addAttribute("formData", formData);
        
		return "index";
	}	
	
	   public static class FormData {
	        private String language;
	        private String theme;
	        
			public String getLanguage() {
				return language;
			}

			public void setLanguage(String language) {
				this.language = language;
			}

			public String getTheme() {
				return theme;
			}

			public void setTheme(String theme) {
				this.theme = theme;
			}
			
			
	    }	
	   
	   
	   // /error is coming normally from container's default error page (the mapping is defined in web.xml exclusively; cannot be defined programmtically)
	   @RequestMapping(path = "/error.html")	   
		public ModelAndView handleException(HttpServletRequest request, Exception ex) { 
			System.out.println("2.Request " + request.getRequestURL() + " Threw an Exception"); 
			
			ModelAndView mav = new ModelAndView(); 
			mav.addObject("exception", "Error found !"); 
			mav.addObject("url", request.getRequestURL()); 
			mav.setViewName("error"); 
			
			return mav; 
		}	   
}
