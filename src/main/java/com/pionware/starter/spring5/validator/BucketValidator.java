package com.pionware.starter.spring5.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import com.pionware.starter.spring5.model.Bucket;
import com.pionware.starter.spring5.service.S3Service;

@Scope(value=WebApplicationContext.SCOPE_REQUEST,  
	proxyMode=ScopedProxyMode.TARGET_CLASS)  // the proxy mode being set here allows to inject it as usually 
@Component("bucketValidator")
public class BucketValidator implements Validator { 
	@Autowired
	private S3Service s3Service;
	
	public BucketValidator() {
		System.out.println("Creating BucketValidator...");
	}		
	public boolean supports(Class<?> _class) { 
		return _class.equals(Bucket.class); 
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Bucket bucket = (Bucket) obj; 

		if(s3Service.nameExists(bucket.getName())) { 
			errors.rejectValue("name", "bucketName.not.unique"); 
		} 
		
	} 
} 
