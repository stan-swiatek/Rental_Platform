package com.fdmgroup.RentalPlatform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Booking;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.BookingRepository;



@Service
public class BookingService implements IBookingService {
	
	@Autowired
	private BookingRepository repo;

	@Override
	public List<Booking> findByUser(User user) {
		return repo.findByUser(user);
	}

	@Override
	public List<Booking> findByProduct(Product product) {
		return repo.findByProduct(product);
	}

	@Override
	public List<Booking> findAll() {
		return repo.findAll();
	}

	@Override
	public void saveBooking(Booking booking) {
		repo.save(booking);		
	}

}
