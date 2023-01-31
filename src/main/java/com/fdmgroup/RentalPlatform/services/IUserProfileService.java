package com.fdmgroup.RentalPlatform.services;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;

public interface IUserProfileService {
	
	User editUserDetails(User user);
	User displayUserDetails(User user);
//	User rateUser(Id id);
//	Product rateProduct(Id id);
//	

}
