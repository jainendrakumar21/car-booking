package com.jacademy.carbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacademy.carbooking.entity.Customer;
import com.jacademy.carbooking.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);

	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> findAllCustomers(){
		List<Customer> customers = customerService.findAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> findByCustomerId(@PathVariable Integer customerId){
		Customer customer = customerService.findByCustomerId(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	

}
