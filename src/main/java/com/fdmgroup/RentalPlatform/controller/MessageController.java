package com.fdmgroup.RentalPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.services.IMessageService;
import com.fdmgroup.RentalPlatform.services.IUserService;


@Controller
public class MessageController {
	
	@Autowired
	private LoginAndRegisterController login;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMessageService messageService;
	
	private User user;
	
	
	@GetMapping("/messages/{id}")
	public String getMessages(ModelMap model, @PathVariable int id) {
		login.isLoggedIn(model);
		user = login.getLoggedUser();
		model.addAttribute("messages", messageService.findByOwner(user));
		return "messages";
	}
	
	@GetMapping(value="/messages/{product_id}_{buyer_id}")
	public String goToConversation(ModelMap model, @PathVariable int product_id,@PathVariable int buyer_id) {
		model.addAttribute("messages", messageService.findByOwner(user)); //TODO make it so not all messages are shown
		return "details";
	}
}
