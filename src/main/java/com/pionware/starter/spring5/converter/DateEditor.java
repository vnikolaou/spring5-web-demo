package com.pionware.starter.spring5.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import com.pionware.starter.spring5.utils.DateUtils;

public class DateEditor extends PropertyEditorSupport{ 

	@Override 
	public void setAsText(String text) throws IllegalArgumentException { 
		try { 
			Date date = DateUtils.convertToDate(text);
			setValue(date);
		} catch(ParseException ex) {
			throw new IllegalArgumentException(text);
		}
	} 

	@Override 
	public String getAsText() { 
		return DateUtils.convertToString(new Date()); 
	} 
} 
