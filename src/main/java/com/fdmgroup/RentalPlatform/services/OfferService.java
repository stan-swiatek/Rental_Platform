package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.repository.OfferRepository;


@Service
public class OfferService implements IOfferService {
	
	
	@Autowired
	private OfferRepository repo;

}
