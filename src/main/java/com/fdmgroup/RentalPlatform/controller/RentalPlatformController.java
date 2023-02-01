package com.fdmgroup.RentalPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping(value = "/UserProfile")
	public String goUserProfile(ModelMap model) {
		login.isLoggedIn(model);
		return "UserProfile";
	}
	
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
