package com.pionware.starter.spring5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pionware.starter.spring5.model.Department;
import com.pionware.starter.spring5.model.Employee;

@Controller
public class MainController {
	
	@ResponseBody
	//@RequestMapping("/main.html")
	@GetMapping("/main.html")
	public String pageGenerate(){
		
		String content = "<html>"
				+ "" + "<head><title>MVC Web</title></head>"
				+ "" + "<body>This is Spring MVC Web</body>"
				+ "" + "</html>"
				+ "";
		
		return content;
	}
	
	@RequestMapping("/intro.html")
	public String introPage(){
		return "intro";
	}
	
	@RequestMapping("/welcome.html")
	public String welcomePage(){
		return "welcome";
	}

	@GetMapping("/showEmployeeForm.html") 
	  public ModelAndView showEmployeeForm(ModelMap map)  throws Exception { 
	  Employee employee = new Employee(); 
	  employee.setFirstName("name");
	  map.addAttribute("myEmployee",employee); 
	  return new ModelAndView("employeeForm"); 
	} 	
	
	@ModelAttribute("departments") 
	public List<Department>addAttribute() { 
	  List<Department>departments=new ArrayList<Department>(); 
	  departments.add(new Department(100,"Dept100")); 
	  departments.add(new Department(101,"Dept101")); 
	  return departments; 
	} 
	
	@PostMapping("/addEmployee.html") 
	public ModelAndView addEmployee(@ModelAttribute("myEmployee") Employee employee) throws Exception { 
		System.out.println("===> addEmployee");
	  ModelAndView modelAndView = new ModelAndView(); 
	  modelAndView.setViewName("employeeList"); 
	  //later on the list will be fetched from the table 
	  List<Employee>employees=new ArrayList(); 
	  System.out.println("employee=" + employee);
	  employees.add(employee); 
	  modelAndView.addObject("employeeList",employees); 
	  return modelAndView; 
	} 	
}
