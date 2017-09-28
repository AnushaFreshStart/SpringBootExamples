package com.example.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.entity.Customer;

@Repository
@Transactional
public class CustomerRepository {	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Customer> getCustomers() {
		
		String hql = "FROM Customer";
		
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}

	public String saveCustomer(Customer customer) {
		String retunValue = "";
		
		entityManager.persist(customer);
		
		retunValue = customer.getId();
		return retunValue;
	}

	public Customer getCustomersById(String id) {		
		return entityManager.find(Customer.class, id);
	}

	public String updateCustomer(Customer customer) {
		String retunValue = "";
		
		Customer updatedCustomer = getCustomersById(customer.getId());
		updatedCustomer.setId(customer.getId());
		updatedCustomer.setName(customer.getName());
		entityManager.flush();
		
		retunValue = customer.getId();
		return retunValue;
	}

	public String deleteCustomerById(String id) {
		entityManager.remove(getCustomersById(id));
		return id;
	}
}
