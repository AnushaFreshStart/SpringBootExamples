package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Customer;
import com.example.app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomers()
	{
		return customerRepository.getCustomers();
	}

	public String saveCustomer(Customer customer) {
		
		return customerRepository.saveCustomer(customer);
	}

	public Customer getCustomersById(String id) {
		
		return customerRepository.getCustomersById(id);
	}

	public String updateCustomer(Customer customer) {
		
		return customerRepository.updateCustomer(customer);
	}

	public String deleteCustomerById(String id) {
		
		return customerRepository.deleteCustomerById(id);
	}
}
