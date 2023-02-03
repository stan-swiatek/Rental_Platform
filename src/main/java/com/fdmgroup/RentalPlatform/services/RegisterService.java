package com.fdmgroup.RentalPlatform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.Booking;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.BookingRepository;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;



@Service
public class RegisterService implements IRegisterService {

	@Autowired
	private DefaultUserDetailsService userService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder encoder;

	public String registerSubmit(User user, Address address, String confirmPassword, ModelMap model) {
		Optional<User> userFromDatabase = userService.findByUsername(user.getUsername());
		if (userFromDatabase.isPresent()) {
			model.addAttribute("message", "This user name already exists");
			return "register";
		}
		
		 if (!user.getPassword().equals(confirmPassword)) {
		        model.addAttribute("message", "Passwords do not match");
		        return "register";
		    }
		

		user.setRole(roleService.findByRoleName("Customer"));
		user.setPassword(encoder.encode(user.getPassword()));
		user.setAddress(address);

		addressService.saveAddress(address);
		userService.saveUser(user);
		
		return "index";
	}

}
