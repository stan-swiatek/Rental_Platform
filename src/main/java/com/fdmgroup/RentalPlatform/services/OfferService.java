package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.RentalPlatform.repository.OfferRepository;



public class OfferService implements IOfferService {
	
	
	@Autowired
	private OfferRepository repo;

}
