package com.fdmgroup.RentalPlatform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Rating;
import com.fdmgroup.RentalPlatform.repository.RatingRepository;

@Service
public class RatingService implements IRatingService {
	
  @Autowired	
  private RatingRepository ratingRepository;
  
  @Override
  public Rating create(Rating rating) {
	  return ratingRepository.save(rating);
  }
  
  public Double getAverageRating() {
    List<Rating> ratings = ratingRepository.findAll();
    return ratings.stream()
        .mapToInt(Rating::getValue)
        .average()
        .orElse(0.0);
  }
}

