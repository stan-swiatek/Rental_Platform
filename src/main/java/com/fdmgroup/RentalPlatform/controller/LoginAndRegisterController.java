package com.fdmgroup.RentalPlatform.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.MessageRepository;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;
import com.fdmgroup.RentalPlatform.security.UserPrincipal;
import com.fdmgroup.RentalPlatform.services.AddressService;
import com.fdmgroup.RentalPlatform.services.LogService;
import com.fdmgroup.RentalPlatform.services.MessageService;
import com.fdmgroup.RentalPlatform.services.ProductService;
import com.fdmgroup.RentalPlatform.services.RegisterService;
import com.fdmgroup.RentalPlatform.services.RoleService;


@Controller
public class LoginAndRegisterController {
	@Autowired
	private LogService logService;
	
	@Autowired
	private RegisterService registerService;
	
	

	@GetMapping("/login")
	public String login(ModelMap model) {
		logService.isLoggedIn(model);
		return "login";
	}
//	@GetMapping("/logout")
//	public String logout(ModelMap model) {
//		return "redirect:/logout";
//	}

	@GetMapping("/register")
	public String register(ModelMap model) {
		logService.isLoggedIn(model);
		return "redirect:/login";
	}

	@GetMapping("/logged")
	public String loggedUser(ModelMap model) {
		logService.isLoggedIn(model);
		return "redirect:/";
	}	

	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute("user") User user, @ModelAttribute("address") Address address,
			@RequestParam("confirmPassword") String confirmPassword, ModelMap model) {
		
		return registerService.registerSubmit(user, address, confirmPassword, model);
	}
	
	
	@GetMapping("/forgottenPassword")
	public String ForgottenPassword(ModelMap model) {
		return "forgottenPassword";
	}
	
	
	@PostMapping("/forgottenPassword")
	public String submitForgottenPassword(@RequestParam("email") String email, ModelMap model) {
		if (!email.isEmpty()) {
			model.addAttribute("message4", "");
			model.addAttribute("message3", "Password-reset link was sent to your e-mail");
			return "forgottenPassword";
	    } 
		model.addAttribute("message4", "field cannot be empty");
//		model.addAttribute("message3", "Password-reset link was sent to your e-mail");
		return "forgottenPassword";
	    
	}
	
	
	
	
//	@PostMapping("/login")
//	public String loginSubmit(@RequestParam("username") String username, 
//	                                 @RequestParam("password") String password, ModelMap model) {
//		System.out.println("TEST!!!!!");
//	    Optional<User> userFromDatabase = userService.findByUsername(username);
//	    User user = userFromDatabase.get();
//	    if(!userFromDatabase.isPresent()){
//	        throw new UsernameNotFoundException("User not found");
//	    	model.addAttribute("message2", "User not found");
//	    	return "login";
//	    }	
//	    if(!encoder.matches(password, user.getPassword())){
//		     throw new BadCredentialsException("Wrong username or password");
//		     model.addAttribute("message2", "Wrong username or password");
//		     return "login";
//		     
//			
//	    }
//	    return "index";

//	    User user2 = userFromDatabase.get();
//	    if(!encoder.matches(password, user.getPassword())){
//	        throw new BadCredentialsException("Wrong username or password");
//	        model.addAttribute("message", "Wrong username or password");
//	    }
//	    return "login";
	}
	
		
//	@ExceptionHandler(UsernameNotFoundException.class)
//	public ModelAndView handleUsernameNotFoundException(UsernameNotFoundException e){
//	    ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.addObject("errorMessage", e.getMessage());
//	    modelAndView.setViewName("login");
//	    return modelAndView;
//	}	
	
//	@ExceptionHandler(BadCredentialsException.class)
//	public ModelAndView handleBadCredentialsException(BadCredentialsException e){
//	    ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.addObject("errorMessage", e.getMessage());
//	    modelAndView.setViewName("login");
//	    return modelAndView;
//	}
	
	
	
	
	
	

//	@ExceptionHandler(UsernameNotFoundException.class)
//	public ModelAndView handleUsernameNotFoundException(UsernameNotFoundException ex) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("notFound");
//		mav.addObject("type", "user");
//		mav.addObject("message", ex.getMessage());
//		return mav;
//	}


