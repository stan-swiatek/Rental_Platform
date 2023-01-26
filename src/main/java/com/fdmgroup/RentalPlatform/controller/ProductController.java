package com.fdmgroup.RentalPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.services.IProductService;


@Controller
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping(value="/products")
	public String goToProducts(ModelMap model) {
		return "products";
	}
	
	@PostMapping(value="/products")
	public String createNewProduct(ModelMap model, @ModelAttribute("product") Product product) {

		service.createNewProduct(product);
		populateModel(model);
		return "products";
	}
	
	@GetMapping(value="/products/{id}")
	public String seeDetails(ModelMap model, @PathVariable int id) //throws PlaceNotFoundException 
	{
		model.addAttribute("product", service.findProductById(id));
		return "details";
	}
	
	@PostMapping("/delete")
	public String deleteProduct(ModelMap model, @RequestParam int id) //throws PlaceNotFoundException 
	{
		service.deleteProduct(id);
		populateModel(model);
		return "index";
	}
	
//	@PostMapping("/filtered")
//	public String filterProducts(ModelMap model, @RequestParam String filter) {
//		List<Product> filteredProducts = service.filterProducts(filter);
//		
//		model.addAttribute("filterProducts", filterProducts);
//		populateModel(model);
//		return "index";
//	}
	
	
	private void populateModel(ModelMap model) {
		model.addAttribute("products", service.findAllProducts());
	}


	}
