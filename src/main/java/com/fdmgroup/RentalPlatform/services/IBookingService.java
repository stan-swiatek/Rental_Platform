package com.fdmgroup.RentalPlatform.services;

import java.util.Collection;
import java.util.List;

import com.fdmgroup.RentalPlatform.model.Booking;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;

public interface IBookingService {
	List<Booking> findByUser(User user);
	List<Booking> findByProduct(Product product);
	List<Booking> findAll();
	List<Booking> findByProductAndUser(Product product, User user);
	void saveBooking(Booking booking);
	List<Booking> findByProductAndStatus(Product product, String s);
}
