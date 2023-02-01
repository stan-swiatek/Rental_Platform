package com.fdmgroup.RentalPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
