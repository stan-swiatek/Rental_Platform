package com.fdmgroup.RentalPlatform.services;

import java.util.Collection;
import java.util.List;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;

public interface IMessageService {
	List<Message> findBySubject(String subject);

	List<Message> findByOwner(User user);

	List<Message> findByProduct(Product product);

	List<Message> findByBuyer(User buyer);

	void saveMessage(Message message);
}
