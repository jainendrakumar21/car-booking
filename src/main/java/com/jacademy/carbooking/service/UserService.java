package com.jacademy.carbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacademy.carbooking.entity.User;
import com.jacademy.carbooking.repo.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);
		Optional<UserdetailsImpl> userdetailsImplOptional = user.map(UserdetailsImpl::new);
		if (user.isPresent() && userdetailsImplOptional.isPresent()) {
			return userdetailsImplOptional.get();

		} else {
			throw new UsernameNotFoundException(username + "not found!");
		}
	}

}
