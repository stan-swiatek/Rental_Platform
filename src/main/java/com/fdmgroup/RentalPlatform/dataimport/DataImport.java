package com.fdmgroup.RentalPlatform.dataimport;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.Role;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.AddressRepository;
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
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!userRepository.findByUsername("admin").isPresent()) {

			EntityManager manager = factory.createEntityManager();
			
			User admin = new User("admin", encoder.encode("123"), "admin@admin.pl", "John", "Doe", "123456789");
			Address address1 = new Address("Poland", "Warsaw", "Main St", "00-001", 1, 1);
			userRepository.save(admin);
			admin.setAddress(address1);
			manager.merge(address1);
			addressRepository.save(address1);
			userRepository.save(admin);
			
			User user1 = new User("kuba", encoder.encode("123"), "jakub.kowalczyk@example.com", "Jakub", "Kowalczyk", "123456789");
			userRepository.save(user1);
			user1.setAddress(address1);
			userRepository.save(user1);
			
			User user2 = new User("anna", encoder.encode("123"), "anna.peretiatko@example.com", "Anna", "Peretiatko", "987654321");
			Address address2 = new Address("Poland", "Krakow", "Second St", "00-002", 2, 2);
			userRepository.save(user2);
			user2.setAddress(address2);
			manager.merge(address2);
			addressRepository.save(address2);
			userRepository.save(user2);
			
			User user3 = new User("stan", encoder.encode("123"), "stanislaw.swiatek@example.com", "Stanisław", "Świątek", "111111111");
			Address address3 = new Address("Poland", "Poznań", "Third St", "00-003", 3, 3);
			userRepository.save(user3);
			user3.setAddress(address3);
			manager.merge(address3);
			addressRepository.save(address3);
			userRepository.save(user3);
			
			User user4 = new User("cysia", encoder.encode("123"), "sylwia.lampart-wieckowska@example.com", "Sylwia", "Lampart-Więckowska", "222222222");
			Address address4 = new Address("Poland", "Wrocław", "Fourth St", "00-004", 4, 4);
			userRepository.save(user4);
			user4.setAddress(address4);
			manager.merge(address4);
			addressRepository.save(address4);
			userRepository.save(user4);
			
			User user5 = new User("chris", encoder.encode("123"), "christoph.neustifter@example.com", "Christoph", "Neustifter", "333333333");
			Address address5 = new Address("Germany", "Frankfurt", "Fifth St", "00-005", 5, 5);
			userRepository.save(user5);
			user5.setAddress(address5);
			manager.merge(address5);
			addressRepository.save(address5);
			userRepository.save(user5);
//			Product product = new Product();
//			
//			productRepository.save(product);
			
		}
		
		
		
	}

}