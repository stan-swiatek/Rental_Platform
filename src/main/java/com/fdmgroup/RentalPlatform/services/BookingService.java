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

	@Override
	public List<Booking> findByProductAndUser(Product product, User user) {
		return repo.findByProductAndUser(product, user);
	}

	@Override
	public List<Booking> findByProductAndStatus(Product product, String s) {
		return repo.findByProductAndStatus(product, s);
	}

	@Override
	public List<Booking> findByUserAndStatus(User user, String status) {
		return repo.findByUserAndStatus(user, status);
	}

	@Override
	public Booking findByID(int booking_id) {
		return repo.findById(booking_id).get();
	}

	@Override
	public List<Booking> findByUserAndStatusNot(User user, String string) {
		return repo.findByUserAndStatusNot(user, string);
	}

}
