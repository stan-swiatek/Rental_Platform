package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.repository.BookingRepository;



@Service
public class BookingService implements IBookingService {
	
	@Autowired
	private BookingRepository repo;

}
