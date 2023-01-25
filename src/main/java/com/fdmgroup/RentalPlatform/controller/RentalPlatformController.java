package com.fdmgroup.RentalPlatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RentalPlatformController {
	
	@GetMapping(value="/")
	public String goToIndex() {
		System.out.println("test test");
		return "index";
	}
}
