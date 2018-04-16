package com.pionware.starter.spring5.controller.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pionware.starter.spring5.model.Bucket;
import com.pionware.starter.spring5.model.FileBucket;
import com.pionware.starter.spring5.service.S3Service;
import com.pionware.starter.spring5.validator.FileValidator;

@Controller
@SessionAttributes("author") 
public class S3ViewController {
	@Autowired
	private S3Service s3Service;
	
	@Autowired 
	private LocalValidatorFactoryBean validator; 
	
	@Autowired 
	private Validator bucketValidator;
	
    @Autowired
    private FileValidator fileValidator;
    
	public S3ViewController() {
		System.out.println("Creating S3Controller...");
	}
	@GetMapping("/buckets.html")
	public ModelAndView showBucketList(@ModelAttribute("message") String message) {
	    List<Bucket> buckets = s3Service.getBuckets();

	    if(1==1) throw new RuntimeException("Err !");
	    ModelAndView mv = new ModelAndView("buckets", "bucket_list", buckets);
	    System.out.println("message=" + message);
	    mv.addObject("message", message); // message is a flash attribute being passed from a redirect via RedirectAttributes
	    mv.addObject("author", "Vagelis Nikolaou");
	    return mv;	
	}
	

	@GetMapping("/addBucket.html") 
	public ModelAndView showBucketForm(ModelMap map) throws Exception { 
		Bucket bucket = new Bucket(); 
		map.addAttribute(bucket); 
		return new ModelAndView("bucket-form"); 
	} 	

	@PostMapping("/addBucket.html") 
	public ModelAndView addBook(@Validated @ModelAttribute("bucket") Bucket bucket, 
			 BindingResult bindingResult, ModelMap map, RedirectAttributes attrs) throws Exception { // IMPORTANT: RedirectAttributes parameter goes to the end (the order is extremely important !!!!)
		/*
		 @Validated is for the custom validators while the validator.validate checks the simple validation annotations basically
		 PropertyEditor comes first during Bucket conversion
		 Then the custom validator check comes next
		 Finally the default validation annotations checks come last
		 NOTE: You don't need validator.validate if the @EnableWebMvc is present in SpringDispatcherConfig. 
		 	   In this case the @Validated is enough for all sorts of validations
		 */
		//validator.validate(bucket, bindingResult); 

		if(bindingResult.hasErrors()) { 
			return new ModelAndView("bucket-form"); 
		} 

		s3Service.insertBucket(bucket);
		
		// this works instead of ModelMap.. also note that there is no need to pass it somehow to ModelAndView object
		attrs.addFlashAttribute("message", "The bucket " + bucket.getName() + " was added"); 
		
		String author = (String)map.get("author");
		System.out.println("author=" + author);
		
		return new ModelAndView("redirect:/buckets.html");
	}

	
	@GetMapping(value = "/upload.html")
    public ModelAndView fileUpload(ModelMap model) {
        FileBucket fileBucket = new FileBucket();
        model.addAttribute("fileBucket", fileBucket);
        
        return new ModelAndView("upload-form"); 
    }
 
	@PostMapping(value = "/upload.html")
    public ModelAndView fileUpload(@Validated FileBucket fileBucket,
            BindingResult bindingResult, ModelMap model) throws IOException {
 
        if (bindingResult.hasErrors()) {
            System.out.println("validation errors");
            return new ModelAndView("upload-form"); 
        } else {
            System.out.println("Fetching file");
            MultipartFile multipartFile = fileBucket.getFile();
 
            // Now do something with file...
            try {
            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
            String fileName = multipartFile.getOriginalFilename();
            model.addAttribute("fileName", fileName );
            } catch(Exception ex) {
            	ex.printStackTrace();
            }
            return new ModelAndView("upload-form"); 
        }
    }
    
	@ModelAttribute("zones") 
	public List<String>availableZones() { 
		List<String> zones = new ArrayList<String>(); 
		zones.add("Zone1"); 
		zones.add("Zone2"); 
		return zones; 
	}	
	
	@InitBinder({"bucket"}) 
	private void initBinder(WebDataBinder webDataBinder) { 
	  webDataBinder.addValidators(bucketValidator); // add custom validator apart the basic ones from annotations
	  
	}	

    @InitBinder("fileBucket")
    protected void initBinderFileBucket(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }	
    
    private static String UPLOAD_LOCATION="/home/vnik/my/";
}
