package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.repository.ReviewRepository;


@Service
public class ReviewService implements IReviewService {
	
	
	
	@Autowired
	private ReviewRepository repo;

}
