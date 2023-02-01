package com.fdmgroup.RentalPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.RentalPlatform.model.Rating;
import com.fdmgroup.RentalPlatform.services.RatingService;

@Controller
@RequestMapping("/api/ratings")
public class RatingController {
	
  @Autowired
  private RatingService ratingService;
  
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
  
  @PostMapping ("/rate")
  public String save(ModelMap model, @RequestBody Rating rating) {
    ratingService.create(rating);
    return "redirect:/ProductPage";
  }

  @GetMapping(value="/average")
  public Double getAverageRating() {
	 return ratingService.getAverageRating();
  }

}