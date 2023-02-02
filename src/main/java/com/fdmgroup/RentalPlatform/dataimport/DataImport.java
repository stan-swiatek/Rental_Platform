package com.fdmgroup.RentalPlatform.dataimport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.Role;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.MessageRepository;
import com.fdmgroup.RentalPlatform.repository.ProductRepository;
import com.fdmgroup.RentalPlatform.repository.RoleRepository;
import com.fdmgroup.RentalPlatform.repository.UserRepository;

@Component
public class DataImport implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	@Lazy
	private PasswordEncoder encoder;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!userRepository.findByUsername("Shazar").isPresent()&&!userRepository.findByUsername("admin").isPresent()) {
			Role roleAdmin = new Role("Admin");
			Role roleCustomer = new Role("Customer");

			
			User admin = new User("Shazar", encoder.encode("123"), roleAdmin);

			userRepository.save(admin);
			
			
			User customer = new User("customer", encoder.encode("123"), roleCustomer);
			userRepository.save(customer);
			
			Product product = new Product();
			product.setProductName("Message");
			productRepository.save(product);
			
		}
		
		
		
	}

}