package com.fdmgroup.RentalPlatform.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.MessageRepository;



@Service
public class MessageService implements IMessageService {
	
	@Autowired
	private MessageRepository repo;

	@Override
	public List<Message> findBySubject(String subject) {
		List<Message> messageList = new ArrayList<>();
		messageList = repo.findBySubject(subject);
		return messageList;
	}

	@Override
	public List<Message> findByOwner(User user) {
		List<Message> messageList = new ArrayList<>();
		messageList = repo.findByOwner(user);
		return messageList;
	}
	

}
