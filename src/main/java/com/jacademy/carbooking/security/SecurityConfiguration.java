package com.jacademy.carbooking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * Hard coded authentication 
		 * */
		/*
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
				.password("admin").roles("ADMIN");
		*/
		/*
		 * JPA implementation for authentication
		 * */
		auth.userDetailsService(userDetailsService);

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//Never use this one in Production.
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/booking/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/**").hasRole("ADMIN") // Allow all but except /booking/** for this i have to add this ADMIN to USER'S access also.
		.anyRequest().permitAll()
		.and().httpBasic();
	}

}
