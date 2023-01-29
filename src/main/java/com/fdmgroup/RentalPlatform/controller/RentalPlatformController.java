package com.fdmgroup.RentalPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentalPlatformController {
	
	@Autowired
	private LoginAndRegisterController login;

	
	@GetMapping(value = "/")
	public String goToIndex(ModelMap model) {
		login.isLoggedIn(model);
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

}
