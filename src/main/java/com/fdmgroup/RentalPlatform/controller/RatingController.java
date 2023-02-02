package com.fdmgroup.RentalPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.Rating;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.services.ProductService;
import com.fdmgroup.RentalPlatform.services.RatingService;

@Controller
//@RequestMapping("/api/ratings")
public class RatingController {
	
  @Autowired
  private RatingService ratingService;
  
  @Autowired
  private ProductService productService;
  
  @Autowired
  private LoginAndRegisterController login;
  
  public RatingController(RatingService ratingService) {
    this.ratingService = ratingService;
  }
  
  @GetMapping("/rate")
  public String save(ModelMap model) {
	login.isLoggedIn(model);
	return "redirect:/ProductPage";
  }
  
  @PostMapping ("/rate/{productId}")
  public String save(ModelMap model, @ModelAttribute Rating rating, @PathVariable int productId) {
	Product product = productService.findProductById(productId);  
	User user = product.getOwner();
	rating.setProduct(product);
	rating.setUser(user);
    ratingService.create(rating);
    return "redirect:/ProductPage/" + product.getId();
  }

//  @GetMapping(value="/average")
//  public Double getAverageRating() {
//	 return ratingService.getAverageRating();
//  }

}