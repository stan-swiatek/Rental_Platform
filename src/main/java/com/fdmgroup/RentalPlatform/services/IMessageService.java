package com.fdmgroup.RentalPlatform.services;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.User;

public interface IMessageService {
	Message findBySubject(String subject);

	Message findByOwner(User user);
}
