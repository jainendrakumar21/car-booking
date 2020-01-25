package com.jacademy.carbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacademy.carbooking.entity.Customer;
import com.jacademy.carbooking.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	public Customer findByCustomerId(Integer customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		return customerOptional.isPresent() ? customerOptional.get() : null;
	}
	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}
}
