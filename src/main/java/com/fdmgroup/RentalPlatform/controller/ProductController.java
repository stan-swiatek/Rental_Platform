package com.fdmgroup.RentalPlatform.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fdmgroup.RentalPlatform.model.Address;
import com.fdmgroup.RentalPlatform.model.Booking;
import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.ProductRepository;
import com.fdmgroup.RentalPlatform.services.IBookingService;
import com.fdmgroup.RentalPlatform.services.IMessageService;
import com.fdmgroup.RentalPlatform.services.IProductService;
import com.fdmgroup.RentalPlatform.services.IUserService;
import com.fdmgroup.RentalPlatform.services.ProductService;
import com.fdmgroup.RentalPlatform.model.Review;
import com.fdmgroup.RentalPlatform.services.IRatingService;
import com.fdmgroup.RentalPlatform.services.RatingService;
import com.fdmgroup.RentalPlatform.util.FileUploadUtil;
import com.fdmgroup.RentalPlatform.util.Filtering;


@Controller
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private LoginAndRegisterController login;
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private ProductRepository repo;

	
//	@Autowired
//	private IRatingService rating;
	
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
	public String createNewProduct(@ModelAttribute("product") Product product, ModelMap model,
	                                @RequestParam(value = "image", required = false) MultipartFile multipartFile) throws IOException {
	    user = login.getLoggedUser();
	    product.setOwner(user);
	    
	    if (multipartFile != null && !multipartFile.isEmpty()) {
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        System.out.println(fileName);
	        
	        String uploadDir = "./product-photos/" + product.getId();
	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	        product.setPhotos(uploadDir);
	    }
	    
	    service.createNewProduct(product);
	    populateModel(model);
	    
	    model.addAttribute("product", product);
	    model.addAttribute("productName", product.getProductName());
	    model.addAttribute("productDescription", product.getDescription());
	    model.addAttribute("productCategory", product.getCategory());
	    model.addAttribute("productType", product.getType());
	    model.addAttribute("productColor", product.getColor());
	    model.addAttribute("productPrice", product.getPrice());
	    model.addAttribute("pickUpLocation", product.getPickUpLocation());
	    
	    return "redirect:/ProductPage/" + product.getId();
	}
	
//	@PostMapping(value="/ProductOffer")
//	public String createNewProduct(@ModelAttribute("product") Product product, ModelMap model, @RequestParam("file") MultipartFile multipartFile) throws IOException {
//		user = login.getLoggedUser();
//		product.setOwner(user);
//		
//		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        product.setPhotos(fileName);
//		
//        
//        service.createNewProduct(product);
//        
//        String uploadDir = "user-photos/" + product.getId();
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//        
//		populateModel(model);
//		model.addAttribute("product",product);
//		
//		model.addAttribute("productName", product.getProductName());
//		model.addAttribute("productDescription", product.getDescription());
//		model.addAttribute("productCategory", product.getCategory());
//		model.addAttribute("productType", product.getType());
//		model.addAttribute("productColor", product.getColor());
//		model.addAttribute("productPrice", product.getPrice());
//		model.addAttribute("pickUpLocation", product.getPickUpLocation());
//		
////		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
////        product.setPhotos(fileName);
//         
//       // Product savedProduct = repo.save(product);
// 
//       // String uploadDir = "user-photos/" + savedProduct.getId();
// 
//       // FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//		
////		String productName = product.getProductName();
////		String description = product.getDescription();
////		String category = product.getCategory();
////		String type = product.getType();
////		String color = product.getColor();
////		BigDecimal price = product.getPrice();
//		return "redirect:/ProductPage/" + product.getId();
//	}
	
	
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
		login.isLoggedIn(model);
//		model.addAttribute("product", service.findProductById(id));
		Product product = service.findProductById(id);
//		populateModel(model);
		model.addAttribute("product",product);

		model.addAttribute("productName", product.getProductName());
		model.addAttribute("productDescription", product.getDescription());
		model.addAttribute("productCategory", product.getCategory());
		model.addAttribute("productType", product.getType());
		model.addAttribute("productColor", product.getColor());
		model.addAttribute("productPrice", product.getPrice());
		
		model.addAttribute("productRating", ratingService.getAverageProductRating(product));
		model.addAttribute("userRating", ratingService.getAverageUserRating(product.getOwner()));
		
//		Review review = new Review();
////		review.setProduct(product);
//		model.put("review", review);
		model.addAttribute("pickUpLocation", product.getPickUpLocation());

		user = login.getLoggedUser();
		List<Booking> bookings = bookingService.findByProductAndUser(product, user);
		model.addAttribute("bookings", bookings);
		
		model.addAttribute("isAvailable", isAvailable(product));
		
		return "ProductPage";
	}
	
	@GetMapping("/cart")
	public String getCart(ModelMap model) {
		login.isLoggedIn(model);
		user = login.getLoggedUser();
//		List<Booking> bookings = bookingService.findAll();
		List<Booking> bookings = bookingService.findByUserAndStatus(user, "Cart");
//		messages.addAll(messageService.findByBuyer(user));
//		List<Message> conversations = splitToConversation(messages);
		model.addAttribute("bookings", bookings);
		model.addAttribute("pending", bookingService.findByUserAndStatus(user, "Pending"));
		return "cart";
	}

	
	@RequestMapping(value = "sendReview", method = RequestMethod.POST)
	public String sendReview(
		@ModelAttribute("review") Review review,
		@RequestParam("hdrating") float hdrating,
		HttpSession session) {
//		String username = session.getAttribute("username");
//		review.setRating(hdrating);
//		rating.create(rating);
		return "redirect:/product/detail/";
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
		login.isLoggedIn(model);
		List<Product> finalFilteredProducts = service.filterProducts(filter);
		
		model.addAttribute("filterProducts", finalFilteredProducts);
		populateModel(model);
		return "filtered";
	}
	
	@GetMapping(value="/dropDownFilters")
	public String goToDropDownFilters(ModelMap model) {
		login.isLoggedIn(model);
		return "dropDownFilters";
	}
	
	@PostMapping("/dropDownFilters")
	public String filteringFunction(ModelMap model, @RequestParam String filter, @RequestParam(required = false) String color, @RequestParam(required = false) String category,
			@RequestParam(required = false) String type, @RequestParam(required = false) String minPrice, @RequestParam(required = false) String maxPrice) {
		login.isLoggedIn(model);
		Filtering filtering = new Filtering(color, type, category, minPrice, maxPrice);
		
		List<Product> searchedByColor = new ArrayList<>(0);
		List<Product> searchedByType = new ArrayList<>(0);
		List<Product> searchedByCategory = new ArrayList<>(0);
		List<Product> searchedByPrice = new ArrayList<>(0);
		
		List<Product> searchedProducts = new ArrayList<>();
		
		if (color != "") {
			searchedByColor = service.findProductByColor(color);
			if (searchedProducts.isEmpty())
				searchedProducts.addAll(searchedByColor);
		}
		
		if (type != "") {
			searchedByType = service.findProductByType(type);
			if (searchedProducts.isEmpty())
				searchedProducts.addAll(searchedByType);
		}
		
		if (category != "") {
			searchedByCategory = service.findProductByCategory(category);
			if (searchedProducts.isEmpty())
				searchedProducts.addAll(searchedByCategory);
		}
		
//		if (minPrice != "") {
//			searchedByPrice = service.findProductByPrice(minPrice, maxPrice);
//			if (searchedProducts.isEmpty())
//				searchedProducts.addAll(searchedByPrice);
//		}
		
		if (minPrice != "" && maxPrice != "") {
			searchedByPrice = service.findProductByPrice(minPrice, maxPrice);
			if (searchedProducts.isEmpty())
				searchedProducts.addAll(searchedByPrice);
		} else if (minPrice != "") {
			searchedByPrice = service.findProductByMinPrice(minPrice);
			if (searchedProducts.isEmpty())
				searchedProducts.addAll(searchedByPrice);
		} else if (maxPrice != "") {
			searchedByPrice = service.findProductByMaxPrice(maxPrice);
			if (searchedProducts.isEmpty())
				searchedProducts.addAll(searchedByPrice);
		}
		
		if (color != "") {
			searchedProducts.retainAll(searchedByColor);
		}
		
		if (type != "") {
			searchedProducts.retainAll(searchedByType);
		}
		
		if (category != "") {
			searchedProducts.retainAll(searchedByCategory);
		}
		
//		if (minPrice != "") {
//			searchedProducts.retainAll(searchedByPrice);
//		}
		
		if (minPrice != "" || maxPrice != "") {
			searchedProducts.retainAll(searchedByPrice);
		}
		
		
		model.addAttribute("resultsOfSearch", searchedProducts);
		model.addAttribute("filter", filter);
		model.addAttribute("filtering", filtering);
		
		return "dropDownFilters";
	}
	
	
	
	private void populateModel(ModelMap model) {
		login.isLoggedIn(model);
		model.addAttribute("products", service.findAllProducts());
	}
	@GetMapping("/booking/{booking_id}/accept")
	public String approveBooking(@PathVariable int booking_id,
			ModelMap model) {
		login.isLoggedIn(model);
		Booking booking = bookingService.findByID(booking_id);
		booking.setAccepted(true);
		bookingService.saveBooking(booking);
		Product product = service.findProductById(booking.getProduct().getId());
		product.setAvailable(false);
		service.createNewProduct(product);
		String approvalText = "Your offer have been approved! <br>"
				+ "For product: " + booking.getProduct().getProductName()
				+ "<br>By user: " + product.getOwner().getUsername()
				+ "<br>From: " + booking.getStartDate()
				+ "<br>To: " + booking.getEndDate()
				+ "<br><br>Claim your product at: "+ booking.getProduct().getOwner().getAddress() +"<br>"
				
				;
		sendNotification(booking.getProduct().getOwner(),booking.getUser(),true, booking.getProduct(),approvalText);
		
		return "/index";
	}            
	
	@GetMapping("/booking/{booking_id}/decline")
	public String declineBooking( @PathVariable int booking_id,
			ModelMap model) {
		login.isLoggedIn(model);
		Booking booking = bookingService.findByID(booking_id);
		booking.setAccepted(false);
		String declineText = "Your offer have been declined! <br>"
				+ "Search for other products.";
		sendNotification(booking.getProduct().getOwner(),booking.getUser(),true, booking.getProduct(),declineText);
		return"/index";
	}
	
	
	private void sendNotification(User owner, User buyer, boolean sentByBuyer,Product product, String text) {
		Message message = new Message();
		message.setBuyer(buyer);
		message.setOwner(owner);
		message.setProduct(product);
		message.setMessageText(
				text
				);
		messageService.saveMessage(message);
		
	}
	
	private void sendApproval(User buyer, Booking booking) {
		Message message = new Message();
		User shazar = userService.findByUsername("Shazar");
		message.setBuyer(shazar);
		message.setOwner(buyer);
		message.setProduct(booking.getProduct());
		message.setMessageText(
				"Your offer have been approved! <br>"
				+ "For product: " + booking.getProduct().getProductName()
				+ "<br>By user: " + buyer.getUsername()
				+ "<br>From: " + booking.getStartDate()
				+ "<br>To: " + booking.getEndDate()
				+ "<br><br>Claim your product at: "+ booking.getProduct().getOwner().getAddress() +"<br>"
				
				);
		messageService.saveMessage(message);
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
		String notificationText = "You have new Booking! <br>"
				+ "For product: " + booking.getProduct().getProductName()
				+ "<br>By user: " + product.getOwner().getUsername()
				+ "<br>From: " + booking.getStartDate()
				+ "<br>To: " + booking.getEndDate()
				+ "<br><br>Do you accept?<br>"
				+ "<a href=\"/booking/"+booking.getId()+"/accept\"> Yes </a>"
				+ "<a href=\"/booking/"+booking.getId()+"/decline\"> No </a>";
		sendNotification(product.getOwner(), booking.getUser(),true,product, notificationText);

		user = login.getLoggedUser();
		List<Booking> bookings = bookingService.findByProductAndUser(product, user);
		model.addAttribute("bookings", bookings);
		
		model.addAttribute("isAvailable", isAvailable(product));

		return "ProductPage";
	}
	
	@PostMapping("/delete_item/{booking_id}")
	public String deleteItem(ModelMap model, @PathVariable int booking_id) {
		login.isLoggedIn(model);
		user = login.getLoggedUser();
		
		Booking booking = bookingService.findByID(booking_id);
		booking.setStatus("Discarded");
		bookingService.saveBooking(booking);
		
		List<Booking> bookings = bookingService.findByUserAndStatus(user, "Cart");
		Iterator<Booking> iterator = bookings.iterator();
		while(iterator.hasNext()) {
			Booking newBooking = iterator.next();
			newBooking.setStatus("Pending");
			bookingService.saveBooking(newBooking);
		}
		model.addAttribute("pending", bookingService.findByUserAndStatus(user, "Pending"));
		model.addAttribute("bookings", bookingService.findByUserAndStatus(user, "Cart"));
		return "cart";
	}
	
	boolean isAvailable(Product product) {
		List<String> nope = new ArrayList<String>();
		nope.add("Cart");
		nope.add("Pending");
		
		Iterator<String> iterator = nope.iterator();
		while(iterator.hasNext()) {
			if(bookingService.findByProductAndStatus(product, iterator.next()).size()>0) {
				return false;
			}
		}
		
		return true;
	}
	
	@PostMapping("/confirm_cart")
	public String confirmCart(ModelMap model) {
		login.isLoggedIn(model);
		user = login.getLoggedUser();
		List<Booking> bookings = bookingService.findByUserAndStatus(user, "Cart");
		Iterator<Booking> iterator = bookings.iterator();
		while(iterator.hasNext()) {
			Booking newBooking = iterator.next();
			newBooking.setStatus("Pending");
			bookingService.saveBooking(newBooking);
		}
		model.addAttribute("pending", bookingService.findByUserAndStatus(user, "Pending"));
		model.addAttribute("bookings", bookingService.findByUserAndStatus(user, "Cart"));
		return "cart";
	}
	
	
}
