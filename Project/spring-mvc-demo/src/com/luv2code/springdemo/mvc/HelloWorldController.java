package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String ShowForm()
	{
		return "helloworld-form";
	}
	
	
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
		
	}
	
	
	
	
	
	//controller method to read the form data 
	
	
	
	
	
	
	

}
