package com.jacademy.carbooking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacademy.carbooking.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String username);
	
}
