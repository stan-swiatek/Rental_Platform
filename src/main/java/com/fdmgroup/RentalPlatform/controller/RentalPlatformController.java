package com.fdmgroup.RentalPlatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RentalPlatformController {
	
	@GetMapping(value="/")
	public String goToIndex() {
		return "index";
	}
	
//	@GetMapping(value="/terms")
//	public String goToTerms() {
//		return "terms";
//	}
//	
//	@GetMapping(value="/ProductPage")
//	public String goProductPage() {
//		return "ProductPage";
//	}
	

	
}
