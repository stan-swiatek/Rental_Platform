package com.fdmgroup.RentalPlatform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.Rating;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.RatingRepository;

@Service
public class RatingService implements IRatingService {
	
  @Autowired	
  private RatingRepository ratingRepository;
  
  @Override
  public void create(Rating rating) {
	 ratingRepository.save(rating);
  }
  
  public Double getAverageUserRating(User user) {
    List<Rating> ratings = ratingRepository.findByUser(user);
    return ratings.stream()
        .mapToInt(Rating::getUserValue)
        .average()
        .orElse(0.0);
  }
  
  public Double getAverageProductRating(Product product) {
	    List<Rating> ratings = ratingRepository.findByProduct(product);
	    return ratings.stream()
	        .mapToInt(Rating::getProductValue)
	        .average()
	        .orElse(0.0);
}
}

