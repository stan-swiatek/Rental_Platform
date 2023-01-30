package com.fdmgroup.RentalPlatform.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.MessageRepository;



@Service
public class MessageService implements IMessageService {
	
	@Autowired
	private MessageRepository repo;
	

	@Override
	public List<Message> findBySubject(String subject) {
		return repo.findBySubject(subject);
	}

	@Override
	public List<Message> findByOwner(User user) {
		return repo.findByOwner(user);
	}

	@Override
	public List<Message> findByProduct(Product product) {	
		return repo.findByProduct(product);
	}

	@Override
	public List<Message> findByBuyer(User user) {
		return repo.findByBuyer(user);
	}

	@Override
	public void saveMessage(Message message) {
		repo.save(message);
	}
	
	

}
