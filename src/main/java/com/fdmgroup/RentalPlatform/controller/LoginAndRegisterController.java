package com.fdmgroup.RentalPlatform.controller;

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
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;
import com.fdmgroup.RentalPlatform.security.UserPrincipal;
import com.fdmgroup.RentalPlatform.services.AddressService;
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
	private RoleService roleService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/logged")
	public String loggedUser(ModelMap model) {
		isLoggedIn(model);
		return "index";
	}
	
	public void isLoggedIn(ModelMap model) {
		boolean isLoggedIn = SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
		if (isLoggedIn) {
			UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String firstName = user.getFirstName();
			model.addAttribute("loggedIn", isLoggedIn);
			model.addAttribute("firstname", firstName);
		}
	}
	
	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute("user")User user, ModelMap model) {
		Optional<User> userFromDatabase = userService.findByUsername(user.getUsername());
		if (userFromDatabase.isPresent()) {
			model.addAttribute("message", "This user name already exists");
			return "register";
		}
		
		user.setRole(roleService.findByRoleName("Customer"));
		user.setPassword(encoder.encode(user.getPassword()));
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


