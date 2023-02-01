package com.fdmgroup.RentalPlatform.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.UserRepository;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;
import com.fdmgroup.RentalPlatform.security.UserPrincipal;
import com.fdmgroup.RentalPlatform.services.AddressService;
import com.fdmgroup.RentalPlatform.services.IUserProfileService;
import com.fdmgroup.RentalPlatform.services.RoleService;

@Controller
public class UserProfileController {
	
	@Autowired
	private IUserProfileService service;
	
	@Autowired
	private DefaultUserDetailsService userService;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private LoginAndRegisterController login;
	
	private Address address;
	
	

	//method to populate fields with current values of user details
	
	@GetMapping("/editUserDetails")
	public ModelAndView editUserDetails(ModelMap model) {
		login.isLoggedIn(model);
		ModelAndView modelAndView = new ModelAndView("editUserDetails");
		User loggedUser = login.getLoggedUser();
		modelAndView.addObject("user", loggedUser);
	//	model.addAttribute("user", loggedUser);
		return modelAndView;
	}
	
	
	@GetMapping("/UserProfile")
//	@RequestMapping(value = "/UserProfile", method = RequestMethod.GET)
	public String showUserDetails(ModelMap model) {
		login.isLoggedIn(model);
		User loggedInUser = login.getLoggedUser();
		
		model.addAttribute("userName", loggedInUser.getUsername());
		model.addAttribute("userFristName", loggedInUser.getFirstName());
		model.addAttribute("userSurName", loggedInUser.getSurName());
		model.addAttribute("userEmail", loggedInUser.getEmail());
		model.addAttribute("userPhone", loggedInUser.getPhoneNumber());
		model.addAttribute("userAddress", loggedInUser.getAddress());
		
		
		
		return "UserProfile";
	}
	
	


	
	
	@PostMapping("/editUserDetails")
	public String editUserDetails(@ModelAttribute("user") User updatedUser) {
		System.out.println("current user updated " + updatedUser);
		
	 
	    // Get the current logged-in user from the security context
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    User currentUser = ((UserPrincipal)authentication.getPrincipal()).getUser();
	 
	    // Update the current user's details with the updated information
	    currentUser.setFirstName(updatedUser.getFirstName());
	    currentUser.setSurName(updatedUser.getSurName());
	    currentUser.setEmail(updatedUser.getEmail());
	    currentUser.setPhoneNumber(updatedUser.getPhoneNumber());
	 
	    // Save the updated user to the database
	    
	    User savedUser = userService.saveUser(currentUser);
	 
	    return "UserProfile";
	}
	
	
	
	
	

	
	
	
	
//	@PutMapping("/editUserDetails")
//	public ResponseEntity<User> updateUser(@AuthenticationPrincipal User loggedInUser, @RequestBody User updatedUser) {
//	  loggedInUser.setUsername(updatedUser.getUsername());
//	  // Password should not be updated directly as plain text, but rather it should be hashed and salted before storing it.
//	  loggedInUser.setEmail(updatedUser.getEmail());
//	  loggedInUser.setFirstName(updatedUser.getFirstName());
//	  loggedInUser.setSurName(updatedUser.getSurName());
//	  
//	  // Update address separately
//	  Address updatedAddress = updatedUser.getAddress();
//	  if (updatedAddress != null) {
//	    Address loggedInUserAddress = loggedInUser.getAddress();
//	    if (loggedInUserAddress == null) {
//	      loggedInUserAddress = new Address();
//	      loggedInUser.setAddress(loggedInUserAddress);
//	    }
//	    loggedInUserAddress.setStreet(updatedAddress.getStreet());
//	    // Update other address fields if necessary
//	  }
//	  
//	  try {
//	    userService.saveUser(loggedInUser);
//	    return ResponseEntity.ok(loggedInUser);
//	  } catch (Exception e) {
//	    return ResponseEntity.badRequest().build();
//	  }
//	}



//	@Override
//	public User displayUserDetails(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	


}
