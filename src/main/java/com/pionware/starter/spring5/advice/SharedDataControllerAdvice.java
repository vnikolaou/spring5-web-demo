package com.pionware.starter.spring5.advice;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice 
public class SharedDataControllerAdvice {
	@ModelAttribute("locales") 
	public Map<String, String> locales() { 
	    Map<String, String> locales = new LinkedHashMap<>();
	    
	    Locale l = Locale.US;
	    locales.put(l.toString(), l.getDisplayLanguage());
	    
	    l = new Locale("el","EL");
	    locales.put(l.toString(), l.getDisplayLanguage());

	    l = Locale.FRANCE;
	    locales.put(l.toString(), l.getDisplayLanguage());
	    
	    return locales;
	}	
	
	@ModelAttribute("themes") 
	public Map<String, String> themes() { 
	    Map<String, String> themes = new LinkedHashMap<>();
	    
	    themes.put("theme1", "Blue (theme1)");
	    themes.put("theme2", "Green (theme2)");
	    return themes;
	}		
}
