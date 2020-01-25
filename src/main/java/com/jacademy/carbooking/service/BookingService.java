package com.jacademy.carbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacademy.carbooking.entity.Booking;
import com.jacademy.carbooking.entity.Customer;
import com.jacademy.carbooking.repo.BookingRepository;
import com.jacademy.carbooking.repo.CustomerRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	CustomerRepository customerRepository;

	public Booking findByBookingId(Integer bookingId) {
		Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
		return bookingOptional.isPresent() ? bookingOptional.get() : null;
	}

	public List<Booking> findAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking addNewBooking(Booking booking, Integer customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			booking.setCustomer(customer.get());
			bookingRepository.save(booking);
			return booking;
		} else {
			return null;
		}

	}

}
