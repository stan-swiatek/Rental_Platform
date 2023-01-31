package com.fdmgroup.RentalPlatform.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
		List<Message> messages = messageService.findByOwner(user);
		messages.addAll(messageService.findByBuyer(user));
		List<Message> conversations = splitToConversation(messages);
		model.addAttribute("messages", conversations);
		return "messages";
	}

	@GetMapping(value = "/messages/{product_id}/{buyer_id}")
	public String goToConversation(ModelMap model, @PathVariable int product_id, @PathVariable int buyer_id) {
		login.isLoggedIn(model);
		populateConversation(model, product_id, buyer_id);
		return "conversation";
	}

	@PostMapping(value = "/sendMessage/{product_id}/{buyer_id}")
	public String sendMessage(ModelMap model, @ModelAttribute Message message, @PathVariable int product_id,
			@PathVariable int buyer_id) {
		product = productService.findProductById(product_id);
		message.setOwner(product.getOwner());
		message.setBuyer(userService.findByUserId(buyer_id));
		message.setProduct(product);
		message.setTimeSent(new Date());
		message.setSubject(product.getProductName());
		if(login.getLoggedUser().getId() == buyer_id) {
			message.setSentByBuyer(true);
		}else {
			message.setSentByBuyer(false);
		}
		messageService.saveMessage(message);
		login.isLoggedIn(model);
		populateConversation(model, product_id, buyer_id);
		return "conversation";
	}

	public void populateConversation(ModelMap model, int product_id, int buyer_id) {
		product = productService.findProductById(product_id);
		user = product.getOwner();
		buyer = userService.findByUserId(buyer_id);
		System.out.println("Buyer: " + buyer + ", " + "/nOwner: " + user);
		// Find all messages for this owner
		List<Message> messagesByOwnerAndProduct = messageService.findByOwner(user);
		System.out.println(messagesByOwnerAndProduct);
		// Filter for only messages with this product
		messagesByOwnerAndProduct.retainAll(messageService.findByProduct(product));
		System.out.println(messagesByOwnerAndProduct);
		// Filter for only messages with this buyer
		messagesByOwnerAndProduct.retainAll(messageService.findByBuyer(buyer));
		System.out.println(messagesByOwnerAndProduct);
		model.addAttribute("product", product);
		model.addAttribute("owner",user);
		model.addAttribute("buyer",buyer);
		model.addAttribute("messages", messagesByOwnerAndProduct);
	}

	public List<Message> splitToConversation(List<Message> messages) {
		List<Message> conversations = new ArrayList<>();
		for (Message message : messages) {
			boolean found = false;
			for (Message conversation : conversations) {
				if (message.getOwner().equals(conversation.getOwner())
						&& message.getBuyer().equals(conversation.getBuyer())
						&& message.getProduct().equals(conversation.getProduct())) {
					conversation = message;
					found = true;
					break;
				}
			}
			if (!found) {
				conversations.add(message);
			}
		}
		return conversations;
	}

}
