//package com.fdmgroup.RentalPlatform.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fdmgroup.RentalPlatform.model.Rating;
//import com.fdmgroup.RentalPlatform.services.RatingService;
//
//@Controller
//@RequestMapping("/api/ratings")
//public class RatingController {
//	
//  @Autowired
//  private RatingService ratingService;
//  
//  public RatingController(RatingService ratingService) {
//    this.ratingService = ratingService;
//  }
//  
//  @PostMapping
//  public Rating save(@RequestBody Rating rating) {
//    return ratingService.save(rating);
//  }
//  
//  @GetMapping(value="/average")
//  public Double getAverageRating() {
//    return ratingService.getAverageRating();
//  }
//}

