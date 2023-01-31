package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.UserProfileRepository;



@Service
public class UserProfileService implements IUserProfileService {
	
	@Autowired
	private UserProfileRepository repo;

	
	//Update crude operation, including address edition
	@Override
	public User editUserDetails(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User displayUserDetails(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// link to add product
	
	
	// link to messages
	
	
	
	
	
	

}
