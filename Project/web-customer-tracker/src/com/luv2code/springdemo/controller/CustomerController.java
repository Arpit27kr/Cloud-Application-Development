package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the dao inside the controller
	
	//@Autowired // spring will scan for component that implements customerdao interface
//	private CustomerDAO customerDAO;
	
	
	
	//injecting the customerservice 
	@Autowired
	 private CustomerService customerService;
	
	
	
	
	@RequestMapping("/list")
	
	public String listCustomer(Model theModel)
	{
		
		List<Customer> theCustomers=customerService.getCustomers(); //get customer from service
		
		theModel.addAttribute("customers", theCustomers); // add customer inside the model 
		
		return "list-customer";
	}
	
	/*
	public String listCustomer(Model theModel) {
	    new Thread(() -> {
	        List<Customer> theCustomers = customerService.getCustomers(); 
	        theModel.addAttribute("customers", theCustomers); 
	    }).start();

	    return "list-customer";
	}
	*/

	
	
	@GetMapping("/showFormForAdd")
	public String showForForAdd(Model theModel)
	{
		
		Customer theCustomer =new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		
		
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer)
	{
		
		
		customerService.saveCustomer(theCustomer);
		
		

		return "redirect:/customer/list";
		
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
	{
		
		Customer theCustomer=customerService.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		
		
		
		return"customer-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
		

	}
	
	/*
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
	    new Thread(() -> {
	        customerService.deleteCustomer(theId);
	    }).start();

	    return "redirect:/customer/list";
	}
	
*/
	
	  @GetMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {
	        // search customers from the service
	        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
	                
	        // add the customers to the model
	        theModel.addAttribute("customers", theCustomers);
	        return "list-customer";        
	    }
	
	
}
