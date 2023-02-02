package com.fdmgroup.RentalPlatform.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.Review;
import com.fdmgroup.RentalPlatform.services.IProductService;
import com.fdmgroup.RentalPlatform.services.IRatingService;
import com.fdmgroup.RentalPlatform.services.RatingService;


@Controller
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private LoginAndRegisterController login;
	
//	@Autowired
//	private IRatingService rating;
	

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
		service.createNewProduct(product);
		populateModel(model);
		
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
		populateModel(model);
		
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
		
		
		return "ProductPage";
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
		model.addAttribute("products", service.findAllProducts());
	}


}
