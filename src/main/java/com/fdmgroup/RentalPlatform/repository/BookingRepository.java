package com.fdmgroup.RentalPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Booking;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	List<Booking> findByUser(User user);

	List<Booking> findByProduct(Product product);
	
	List<Booking> findByProductAndUser(Product product, User user);

	List<Booking> findAll();

	List<Booking> findByProductAndStatus(Product product, String s);
	
	List<Booking> findByUserAndStatus(User user, String status);

}
