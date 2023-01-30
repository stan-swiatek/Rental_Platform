package com.fdmgroup.RentalPlatform.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.services.IMessageService;
import com.fdmgroup.RentalPlatform.services.IProductService;
import com.fdmgroup.RentalPlatform.services.IUserService;


@Controller
public class MessageController {
	
	@Autowired
	private LoginAndRegisterController login;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private IProductService productService;
	
	private User user, buyer;
	
	private Product product;
	
	@GetMapping("/messages/{id}")
	public String getMessages(ModelMap model, @PathVariable int id) {
		login.isLoggedIn(model);
		user = login.getLoggedUser();
		model.addAttribute("messages", messageService.findByOwner(user));
		return "messages";
	}
	
	@GetMapping(value="/messages/{product_id}/{buyer_id}")
	public String goToConversation(ModelMap model, @PathVariable int product_id,@PathVariable int buyer_id) {
		
		user = login.getLoggedUser();
		buyer = userService.findByUserId(buyer_id);
		product = productService.findProductById(product_id);
		//Find all messages for this owner
		List<Message> messagesByOwnerAndProduct = messageService.findByOwner(user);
		System.out.println(messagesByOwnerAndProduct);
		//Filter for only messages with this product
		messagesByOwnerAndProduct.retainAll(messageService.findByProduct(product));
		System.out.println(messagesByOwnerAndProduct);
		//Filter for only messages with this buyer
		messagesByOwnerAndProduct.retainAll(messageService.findByBuyer(buyer));
		System.out.println(messagesByOwnerAndProduct);
		model.addAttribute("messages", messagesByOwnerAndProduct); 
		return "messages";
	}
}
