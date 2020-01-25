package com.jacademy.carbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacademy.carbooking.entity.Booking;
import com.jacademy.carbooking.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;

	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> findAllBookings() {
		return new ResponseEntity<>(bookingService.findAllBookings(), HttpStatus.OK);
	}

	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<Booking> findByBookingId(@PathVariable Integer bookingId) {
		return new ResponseEntity<>(bookingService.findByBookingId(bookingId), HttpStatus.OK);
	}

	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking, @RequestParam Integer customerId) {
		return new ResponseEntity<>(bookingService.addNewBooking(booking, customerId), HttpStatus.OK);

	}
}
