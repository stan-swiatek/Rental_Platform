package com.fdmgroup.RentalPlatform.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.services.ProductService;


import com.fdmgroup.RentalPlatform.services.LogService;

@Controller
public class RentalPlatformController {
	
	@Autowired
	private LogService login;
	
	@Autowired
	private ProductService productService;

	
	@GetMapping(value = "/")
	public String goToIndex(ModelMap model) {
		login.isLoggedIn(model);
		List<Product> allProducts = productService.findAllProducts();
		Collections.shuffle(allProducts);
	    List<Product> listOfProducts = allProducts.subList(0, 4);
		model.addAttribute("listOfProducts", listOfProducts);
		return "index";
	}

	@GetMapping(value = "/terms")
	public String goToTerms(ModelMap model) {
		login.isLoggedIn(model);
		return "terms";
	}

	@GetMapping(value = "/ProductPage")
	public String goProductPage(ModelMap model) {
		login.isLoggedIn(model);
		return "ProductPage";
	}
	
//	@GetMapping(value = "/UserProfile")
//	public String goUserProfile(ModelMap model) {
//		login.isLoggedIn(model);
//		return "UserProfile";
//	}
//	
	@GetMapping(value = "/Information")
	public String goInformation(ModelMap model) {
		login.isLoggedIn(model);
		return "Information";
	}
	
	@GetMapping(value = "/AboutUs")
	public String goAboutUs(ModelMap model) {
		login.isLoggedIn(model);
		return "AboutUs";
	}
	
	@GetMapping(value = "/FAQ")
	public String goFAQ(ModelMap model) {
		login.isLoggedIn(model);
		return "FAQ";
	}

}
