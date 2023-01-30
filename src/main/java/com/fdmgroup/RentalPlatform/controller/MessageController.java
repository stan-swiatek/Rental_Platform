package com.fdmgroup.RentalPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.services.IMessageService;
import com.fdmgroup.RentalPlatform.services.IUserService;

public class MessageController {
	
	@Autowired
	private LoginAndRegisterController login;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private User user;
	
	
	@GetMapping("/messages")
	public String getMessages(ModelMap model) {
		login.isLoggedIn(model);
		user = login.getLoggedUser();
		model.addAttribute("messages", messageService.findByOwner(user));
		return "messages";
	}
}
