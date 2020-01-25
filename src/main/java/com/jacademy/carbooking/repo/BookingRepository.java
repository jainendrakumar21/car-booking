package com.jacademy.carbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacademy.carbooking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
