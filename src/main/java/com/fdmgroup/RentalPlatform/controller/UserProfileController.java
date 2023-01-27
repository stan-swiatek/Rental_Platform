package com.fdmgroup.RentalPlatform.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;
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
	private RoleService roleService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	// edit prifle details option still to be chagnes as for now it is copy of register func
	@PostMapping(value="/edituser")
	public String editUserDetails(@ModelAttribute("user")User user, @ModelAttribute("address") Address address, ModelMap model)  {
		Optional<User> userFromDatabase = userService.findByUsername(user.getUsername());
		if (userFromDatabase.isPresent()) {
			model.addAttribute("message", "This user name already exists");
			return "edituser";
		}
		
		user.setRole(roleService.findByRoleName("Customer"));
		user.setPassword(encoder.encode(user.getPassword()));
		user.setAddress(address);
		
		addressService.saveAddress(address);
		userService.saveUser(user);
		return "userprofile";
	}


//	@Override
//	public User displayUserDetails(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	


}
