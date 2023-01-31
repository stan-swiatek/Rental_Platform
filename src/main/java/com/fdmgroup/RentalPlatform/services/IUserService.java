package com.fdmgroup.RentalPlatform.services;

import com.fdmgroup.RentalPlatform.model.User;

public interface IUserService {
	User findByUsername(String username);

	User findByUserId(int buyer_id);
}
