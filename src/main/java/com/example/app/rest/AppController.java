package com.example.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.Customer;
import com.example.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class AppController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/getCustomers", method = RequestMethod.GET)
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@RequestMapping(value="/getCustomers/{id}", method = RequestMethod.GET)
	public Customer getCustomersById(@PathVariable("id") String id)
	{
		return customerService.getCustomersById(id);
	}
	
	@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
	public String saveCustomer(@RequestBody Customer customer)
	{
		return customerService.saveCustomer(customer);
	}
	
	@RequestMapping(value="/updateCustomer", method=RequestMethod.PUT)
	public String updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
	}
	
	@RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.DELETE)
	public String deleteCustomerById(@PathVariable("id") String id)
	{
		return customerService.deleteCustomerById(id);
	}
	
}
