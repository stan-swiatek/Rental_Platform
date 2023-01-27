package com.fdmgroup.RentalPlatform.dataimport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fdmgroup.RentalPlatform.model.Role;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.UserRepository;

@Component
public class DataImport implements ApplicationRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	@Lazy
	private PasswordEncoder encoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!userRepository.findByUsername("admin").isPresent()) {
			Role roleAdmin = new Role("Admin");
			Role roleCustomer = new Role("Customer");

			User admin = new User("admin", encoder.encode("123"), roleAdmin);
			userRepository.save(admin);
			
			User customer = new User("customer", encoder.encode("123"), roleCustomer);
			userRepository.save(customer);
		}
	}

}

