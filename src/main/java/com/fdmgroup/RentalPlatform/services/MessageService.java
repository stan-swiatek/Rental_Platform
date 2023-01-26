package com.fdmgroup.RentalPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.repository.MessageRepository;



@Service
public class MessageService implements IMessageService {
	
	@Autowired
	private MessageRepository repo;

}
