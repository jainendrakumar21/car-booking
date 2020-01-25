package com.jacademy.carbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacademy.carbooking.entity.Customer;

@Repository
public interface CustomerRepository extends  JpaRepository<Customer, Integer> {

}
