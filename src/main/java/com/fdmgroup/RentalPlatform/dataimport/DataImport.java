package com.fdmgroup.RentalPlatform.dataimport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
			//Dummy users
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
			
			//Add dummy products
			List<Product> products = new ArrayList<>();

			String[] names = {"Schwinn Fairhaven", "Sixthreezero Around the Block", "Huffy Nel Lusso", "Mongoose Excursion",
							  "Schwinn Discover", "Sixthreezero Ride in the Park", "Huffy Pantera", "Mongoose Dolomite",
							  "Schwinn Koenig", "Sixthreezero Every Journey"};
			String[] descriptions = {"Comfortable and stylish city bike", "Ideal for leisurely rides in the park", 
									 "Sporty and stylish mountain bike", "Powerful fat tire bike for all terrains", 
									 "Lightweight and efficient road bike", "Stylish beach cruiser bike", 
									 "Rugged and reliable BMX bike", "Smooth and comfortable electric bike", 
									 "Elegant and efficient gravel bike", "Sturdy and versatile unisex bike"};
			String[] categories = {"City Bike", "City Bike", "Mountain Bike", "Mountain Bike", "Road Bike", "City Bike",
								   "BMX", "Electric Bike", "Gravel", "Unisex Bike"};
			String[] types = {"Ladies Bike", "Men's Bike", "Children's Bike", "Men's Bike", "Men's Bike", "Ladies Bike", 
							  "Men's Bike", "Unisex Bike", "Unisex Bike", "Unisex Bike"};
			String[] colors = {"Black", "Blue", "Green", "Pink", "Red", "White", "Yellow", "Other", "Other", "Other"};
			double[] prices = {289.99, 199.99, 139.99, 599.99, 799.99, 299.99, 199.99, 999.99, 799.99, 599.99};
			String[] pickUpLocations = {user5.getAddress().getCity(),user1.getAddress().getCity(), 
					user2.getAddress().getCity(), user3.getAddress().getCity(), 
					user4.getAddress().getCity(), user5.getAddress().getCity(), 
					user1.getAddress().getCity(), user2.getAddress().getCity(), 
					user3.getAddress().getCity(), user4.getAddress().getCity()};
			
			User[] owners = {user5, user1, user2, user3, user4, user5, user1, user2, user3, user4};

			for (int i = 0; i < 10; i++) {
				Product product = new Product();
				product.setProductName(names[i]);
				product.setDescription(descriptions[i]);
				product.setCategory(categories[i]);
				product.setType(types[i]);
				product.setColor(colors[i]);
				product.setPrice(prices[i]);
				product.setPickUpLocation(pickUpLocations[i]);
				product.setOwner(owners[i]);
				product.setAvailable(true);
				product.setImageUrl(Arrays.asList("/img/"+ i + "_1"));;
				products.add(product);
			}

			productRepository.saveAll(products);

			
		}
		
		
		
	}

}