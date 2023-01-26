package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.RentalPlatform.repository.ReviewRepository;



public class ReviewService implements IReviewService {
	
	
	
	@Autowired
	private ReviewRepository repo;

}
