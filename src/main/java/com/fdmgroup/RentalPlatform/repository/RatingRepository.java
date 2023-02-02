package com.fdmgroup.RentalPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.Rating;
import com.fdmgroup.RentalPlatform.model.User;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

	List<Rating> findByUser(User user);

	List<Rating> findByProduct(Product product);
}
