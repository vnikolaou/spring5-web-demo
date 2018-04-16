package com.pionware.starter.spring5.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils {
	private static final SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy"); 
	
	public static Date convertToDate(String text) throws ParseException {
		if(text == null || "".equals(text.trim())) return null;
		return sdf.parse(text); 		
	}
	
	public static String convertToString(Date date) { 
		if(date == null) return null;
		return sdf.format(date); 
	} 	
}
