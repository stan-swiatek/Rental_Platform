package com.fdmgroup.RentalPlatform.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.Booking;
import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.services.IBookingService;
import com.fdmgroup.RentalPlatform.services.IMessageService;
import com.fdmgroup.RentalPlatform.services.IProductService;
import com.fdmgroup.RentalPlatform.services.IUserService;


@Controller
public class ProductController {
	
	@Autowired
	private IProductService service;
	@Autowired
	private LoginAndRegisterController login;

	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private IUserService userService;
	
	User user;

	@GetMapping(value = "/ProductOffer")
	public String goProductOffer(ModelMap model) {
		login.isLoggedIn(model);
		return "ProductOffer";
	}

	// original method before making changes to display data in productpage		
	
//	@PostMapping(value="/ProductOffer")
//	public String createNewProduct(@ModelAttribute("product") Product product, ModelMap model) {
//		service.createNewProduct(product);
//		populateModel(model);		
//		return "UserProfile";
//	}
	
	
	@PostMapping(value="/ProductOffer")
	public String createNewProduct(@ModelAttribute("product") Product product, ModelMap model) {
		user = login.getLoggedUser();
		product.setOwner(user);
		service.createNewProduct(product);
		model.addAttribute("product",product);
		model.addAttribute("productName", product.getProductName());
		model.addAttribute("productDescription", product.getDescription());
		model.addAttribute("productCategory", product.getCategory());
		model.addAttribute("productType", product.getType());
		model.addAttribute("productColor", product.getColor());
		model.addAttribute("productPrice", product.getPrice());
//		String productName = product.getProductName();
//		String description = product.getDescription();
//		String category = product.getCategory();
//		String type = product.getType();
//		String color = product.getColor();
//		BigDecimal price = product.getPrice();
		return "redirect:/ProductPage/" + product.getId();
	}
	
	
// original method before making changes to display data in productpage	
	
//	@GetMapping(value="/products/{id}")
//	public String seeDetails(ModelMap model, @PathVariable int id) //throws PlaceNotFoundException 
//	{
//		model.addAttribute("product", service.findProductById(id));
//		return "details";
//	}
	
	
	@GetMapping(value="/ProductPage/{id}")
	public String seeDetails(ModelMap model, @PathVariable int id) //throws PlaceNotFoundException 
	{
//		model.addAttribute("product", service.findProductById(id));
		Product product = service.findProductById(id);
		//populateModel(model);
		login.isLoggedIn(model);
		model.addAttribute("product",product);
		model.addAttribute("productName", product.getProductName());
		model.addAttribute("productDescription", product.getDescription());
		model.addAttribute("productCategory", product.getCategory());
		model.addAttribute("productType", product.getType());
		model.addAttribute("productColor", product.getColor());
		model.addAttribute("productPrice", product.getPrice());
		return "ProductPage";
	}

	@GetMapping("/cart")
	public String getCart(ModelMap model) {
		login.isLoggedIn(model);
		user = login.getLoggedUser();
		List<Booking> bookings = bookingService.findAll();
//		List<Booking> bookings = bookingService.findByUser(user);
//		messages.addAll(messageService.findByBuyer(user));
//		List<Message> conversations = splitToConversation(messages);
		model.addAttribute("bookings", bookings);
		return "cart";
	}
	
	
	
	
	@PostMapping("/delete")
	public String deleteProduct(ModelMap model, @RequestParam int id) //throws PlaceNotFoundException 
	{
		service.deleteProduct(id);
		populateModel(model);
		return "index";
	}
	
	@GetMapping(value="/filtered")
	public String goToFiltered(ModelMap model) {
		login.isLoggedIn(model);
		return "filtered";
	}
	
	@PostMapping("/filtered")
	public String filterProducts(ModelMap model, @RequestParam String filter) {
		List<Product> finalFilteredProducts = service.filterProducts(filter);
		
		model.addAttribute("filterProducts", finalFilteredProducts);
		populateModel(model);
		return "filtered";
	}
	
	
	private void populateModel(ModelMap model) {
		login.isLoggedIn(model);
		model.addAttribute("products", service.findAllProducts());
	}

	@PostMapping("/Booking/{product_id}")
	public String registerSubmit(@ModelAttribute Booking booking, @PathVariable int product_id,
			ModelMap model) {
		user = login.getLoggedUser();
		Product product = service.findProductById(product_id);
		booking.setProduct(product);
		booking.setUser(user);
		booking.setStatus("Cart");
		bookingService.saveBooking(booking);
		model.addAttribute("test", booking);
		
//		Optional<User> userFromDatabase = userService.findByUsername(user.getUsername());
//		if (userFromDatabase.isPresent()) {
//			model.addAttribute("message", "This user name already exists");
//			return "register";
//		}
//
//		user.setRole(roleService.findByRoleName("Customer"));
//		user.setPassword(encoder.encode(user.getPassword()));
//		user.setAddress(address);
//
//		addressService.saveAddress(address);
//		userService.saveUser(user);
//		model.addAttribute("places", productService.findAllPlaces());
		//populateModel(model);
		login.isLoggedIn(model);
		model.addAttribute("product",product);
		model.addAttribute("productName", product.getProductName());
		model.addAttribute("productDescription", product.getDescription());
		model.addAttribute("productCategory", product.getCategory());
		model.addAttribute("productType", product.getType());
		model.addAttribute("productColor", product.getColor());
		model.addAttribute("productPrice", product.getPrice());
		sendNotification(product.getOwner(), booking);
		return "ProductPage";
	}

	private void sendNotification(User owner, Booking booking) {
		Message message = new Message();
		User shazar = userService.findByUsername("Shazar");
		message.setBuyer(shazar);
		message.setOwner(owner);
		message.setProduct(booking.getProduct());
		message.setMessageText(
				"You have new Booking! /n"
				+ "For product: " + booking.getProduct().getProductName()
				+ "<br>By user: " + owner.getUsername()
				+ "<br>From: " + booking.getStartDate()
				+ "<br>To: " + booking.getEndDate()
				+ "<br><br>Do you accept?<br>"
				+ "<a href=\"/booking/"+booking.getId()+"/accept\"> Yes </a>"
				+ "<a href=\"/booking/"+booking.getId()+"/decline\"> No </a>"
				);
		messageService.saveMessage(message);
		
	}
}
