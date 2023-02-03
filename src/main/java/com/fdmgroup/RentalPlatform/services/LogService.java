package com.fdmgroup.RentalPlatform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.MessageRepository;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;
import com.fdmgroup.RentalPlatform.security.UserPrincipal;

@Service
public class LogService {
	@Autowired
	private DefaultUserDetailsService userService;
	
	@Autowired
	private MessageRepository messageRepository;

	public boolean isLoggedIn() {
		return  SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
	}
	
	public User getLoggedUser() {
		if (isLoggedIn()) {
			UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userService.findByUsername(userPrincipal.getUsername()).get();
			return user;
		}
		return null;
	}


	//Perform the login check and inject user info to the header if logged in.
	public boolean isLoggedIn(ModelMap model) {

		boolean isLoggedIn = isLoggedIn();
		if (isLoggedIn) {
			UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("loggedIn", isLoggedIn);
			model.addAttribute("firstname", user.getFirstName());
			model.addAttribute("user_id", user.getId());
			
			int unread = checkUnreadMessages(getLoggedUser());
			model.addAttribute("unread",unread);
		}
		return isLoggedIn;
	}
	
	public int checkUnreadMessages(User user) {
		int unread = 0;
		System.out.println(user);
		List<Message> allMessages = messageRepository.findByBuyer(user);
		allMessages.addAll(messageRepository.findByOwner(user));
		System.out.println("Number of messages" + allMessages.size());
		for(Message message : allMessages) {
			if(message.getOwner().equals(user)&&message.isSentByBuyer()&&!message.getisRead()) {
				unread++;
			}else if(message.getBuyer().equals(user)&&!message.isSentByBuyer()&&!message.getisRead()) {
				unread++;
			}
		}
		
		return unread;
	}
}
