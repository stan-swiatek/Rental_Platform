package com.fdmgroup.RentalPlatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.MessageRepository;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;
import com.fdmgroup.RentalPlatform.security.UserPrincipal;
import com.fdmgroup.RentalPlatform.services.AddressService;
import com.fdmgroup.RentalPlatform.services.MessageService;
import com.fdmgroup.RentalPlatform.services.ProductService;
import com.fdmgroup.RentalPlatform.services.RoleService;


@Controller
public class LoginAndRegisterController {

	@Autowired
	private DefaultUserDetailsService userService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private RoleService roleService;

	@GetMapping("/login")
	public String login(ModelMap model) {
		isLoggedIn(model);
		return "login";
	}
//	@GetMapping("/logout")
//	public String logout(ModelMap model) {
//		return "redirect:/logout";
//	}

	@GetMapping("/register")
	public String register(ModelMap model) {
		isLoggedIn(model);
		return "register";
	}

	@GetMapping("/logged")
	public String loggedUser(ModelMap model) {
		isLoggedIn(model);
		return "index";
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
	
	private int checkUnreadMessages(User user) {
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
		
		System.out.println("Unread messages " + unread );
		return unread;
	}
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

	

	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute("user") User user, @ModelAttribute("address") Address address,
			ModelMap model) {
		Optional<User> userFromDatabase = userService.findByUsername(user.getUsername());
		if (userFromDatabase.isPresent()) {
			model.addAttribute("message", "This user name already exists");
			return "register";
		}

		user.setRole(roleService.findByRoleName("Customer"));
		user.setPassword(encoder.encode(user.getPassword()));
		user.setAddress(address);

		addressService.saveAddress(address);
		userService.saveUser(user);
//		model.addAttribute("places", productService.findAllPlaces());

		return "index";
	}

//	@ExceptionHandler(UsernameNotFoundException.class)
//	public ModelAndView handleUsernameNotFoundException(UsernameNotFoundException ex) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("notFound");
//		mav.addObject("type", "user");
//		mav.addObject("message", ex.getMessage());
//		return mav;
//	}

}
