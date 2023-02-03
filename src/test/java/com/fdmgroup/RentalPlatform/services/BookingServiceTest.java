package com.fdmgroup.RentalPlatform.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.RentalPlatform.model.Booking;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdmgroup.RentalPlatform.repository.BookingRepository;
import com.fdmgroup.RentalPlatform.security.DefaultUserDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@TestPropertySource(
//  locations = "classpath:application-integrationtest.properties")
public class BookingServiceTest {
	@Autowired
	DefaultUserDetailsService userService = new DefaultUserDetailsService(null);
	
	@Autowired
	BookingService bookingService = new BookingService();
	
	@Autowired
	ProductService productService = new ProductService();
	
	@Test
	public void assertReturnOfOneMatchingOfTotalOfTwoBookings__whenExecuting__BookingService_findByUser() {
		User user1 = new User();
		userService.saveUser(user1);
		User user2 = new User();
		userService.saveUser(user2);
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setUser(user1);
		booking2.setUser(user2);
		bookingService.saveBooking(booking1);
		bookingService.saveBooking(booking2);
		
		List<Booking> bookingsReturned = bookingService.findByUser(user1);
		
		System.out.println("TAGGGG"+bookingService.findAll().size());
		assertEquals(1, bookingsReturned.size());
		assertEquals(booking1, bookingsReturned.get(0));
	}
	
	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findByUser__whenExecuting__BookingService_findByUser() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		BookingRepository tempRepo = bookingService.getRepo();
		bookingService.setRepo(mockRepo);
		
		User mockUser1 = mock(User.class);
//		List<Booking> bookings1 = new ArrayList<Booking>();
//		Booking booking11 = new Booking();
//		booking11.setUser(mockUser1);
//		bookings1.add(booking11);
//		Booking booking12 = new Booking();
//		booking12.setUser(mockUser1);
//		bookings1.add(booking12);
//		
//		when(mockRepo.findByUser(eq(mockUser1))).thenReturn(bookings1);
		
		bookingService.findByUser(mockUser1);
		
		bookingService.setRepo(tempRepo);
		
		verify(mockRepo).findByUser(mockUser1);
	}

	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findByProduct__whenExecuting__BookingService_findByProduct() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		
		Product mockProduct = mock(Product.class);
		
		bookingService.findByProduct(mockProduct);
		
		verify(mockRepo).findByProduct(mockProduct);
	}
	
	@Test
	public void assertReturnOfOneMatchingOfTotalOfTwoBookings__whenExecuting__BookingService_findByProduct() {
		Product product1 = new Product();
		productService.createNewProduct(product1);
		Product product2 = new Product();
		productService.createNewProduct(product2);
		Booking booking1 = new Booking();
		Booking booking2 = new Booking();
		booking1.setProduct(product1);
		booking2.setProduct(product2);
		bookingService.saveBooking(booking1);
		bookingService.saveBooking(booking2);
		
		List<Booking> bookingsReturned = bookingService.findAll();//findByProduct(booking1.getProduct());
//		System.out.println("TTTT "+productService.findAllProducts().size());
//		for(Product product : productService.findAllProducts()) {
//			System.out.println("ID: " + product.getId());
//		}
//
//		System.out.println("ID: " + product1.getId());
//		System.out.println("ID: " + product2.getId());
//		
//		System.out.println("returned");
//		System.out.println("bpID: "+booking1.getProduct().getId());
//		System.out.println("bpID: "+booking2.getProduct().getId());
//		for(Booking booking : bookingsReturned) {
//			System.out.println("bpID: "+booking.getProduct().getId());
//		}
//		
		assertEquals(1, bookingsReturned.size());
		assertEquals(booking1, bookingsReturned.get(0));
	}

	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findAll__whenExecuting__BookingService_findAll() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		
		bookingService.findAll();
		
		verify(mockRepo).findAll();
	}
	
	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_saveBooking__whenExecuting__BookingService_saveBooking() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		Booking booking = mock(Booking.class);
		
		bookingService.saveBooking(booking);
		
		verify(mockRepo).save(booking);
	}

	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findByID__whenExecuting__BookingService_findByID() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		
		int i = 0;
		
		bookingService.findByID(i);
		
		verify(mockRepo).findById(i);
	}

	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findByProductAndUser__whenExecuting__BookingService_findByProductAndUser() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		
		Product testProduct = new Product();
		User testUser = new User();
		
		bookingService.findByProductAndUser(testProduct, testUser);
		
		verify(mockRepo).findByProductAndUser(testProduct, testUser);
	}

	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findByProductAndStatus__whenExecuting__BookingService_findByProductAndStatus() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		
		Product testProduct = new Product();
		String testStatus = "";
		
		bookingService.findByProductAndStatus(testProduct, testStatus);
		
		verify(mockRepo).findByProductAndStatus(testProduct, testStatus);
	}

	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findByUserAndStatus__whenExecuting__BookingService_findByUserAndStatus() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		
		User testUser = new User();
		String testStatus = new String();
		
		bookingService.findByUserAndStatus(testUser, testStatus);
		
		verify(mockRepo).findByUserAndStatus(testUser, testStatus);
	}

	@Test
	public void verifyExecutionOfMehtodCall__BookingRepository_findByUserAndStatusNot__whenExecuting__BookingService_findByUserAndStatusNot() {
		BookingRepository mockRepo = mock(BookingRepository.class);
		bookingService.setRepo(mockRepo);
		
		User testUser = new User();
		String testStatus = new String();
		
		bookingService.findByUserAndStatusNot(testUser, testStatus);
		
		verify(mockRepo).findByUserAndStatusNot(testUser, testStatus);
	}
}
