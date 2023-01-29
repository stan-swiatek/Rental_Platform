package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.repository.AddressRepository;



@Service
public class AddressService implements IAddressService {
	
	@Autowired
	private AddressRepository repo;
	
	
	public void saveAddress(Address address) {
		repo.save(address);
	}
}
