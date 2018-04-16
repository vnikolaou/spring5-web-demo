package com.pionware.starter.spring5.interceptor;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {

		String newLocale = request.getParameter(getParamName());
		System.out.println("getParamName()=" + getParamName() + ", newLocale=" +newLocale );
		return super.preHandle(request, response, handler);
	}
	
	@Override
	protected Locale parseLocaleValue(String locale) {
		Locale l = super.parseLocaleValue(locale);
		System.out.println("l=" + l);
		return l;
	}
}
