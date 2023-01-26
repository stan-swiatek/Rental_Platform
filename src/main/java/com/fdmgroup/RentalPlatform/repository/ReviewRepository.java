package com.fdmgroup.RentalPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.Review;


@Repository
public interface ReviewRepository  extends JpaRepository<Review, Integer> {

}
