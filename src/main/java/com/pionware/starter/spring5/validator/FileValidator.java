package com.pionware.starter.spring5.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import com.pionware.starter.spring5.model.FileBucket;

@Scope(value=WebApplicationContext.SCOPE_REQUEST,  
proxyMode=ScopedProxyMode.TARGET_CLASS)  // the proxy mode being set here allows to inject it as usually 
@Component("fileValidator")
public class FileValidator implements Validator {
     
    public boolean supports(Class<?> clazz) {
        return FileBucket.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
        FileBucket file = (FileBucket) obj;
         
        if(file.getFile()!=null){
            if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
    }
}
