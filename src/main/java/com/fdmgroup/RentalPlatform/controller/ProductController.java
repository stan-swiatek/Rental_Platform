package com.fdmgroup.RentalPlatform.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
import com.fdmgroup.RentalPlatform.util.Filtering;


@Controller
public class ProductController {
	
	@Autowired
	private IProductService service;
	@Autowired
	private LoginAndRegisterController login;
	

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
		return "ProductPage";
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
	
	@GetMapping(value="/dropDownFilters")
	public String goToDropDownFilters(ModelMap model) {
		return "dropDownFilters";
	}
	
	@PostMapping("/dropDownFilters")
	public String filteringFunction(ModelMap model, @RequestParam String filter, @RequestParam String color, @RequestParam String category,
			@RequestParam String type, @RequestParam String minPrice, @RequestParam String maxPrice) {
		
		Filtering filtering = new Filtering(color, type, category, minPrice, maxPrice);
		
		List<Product> searchedByColor = new ArrayList<>(0);
		List<Product> searchedByType = new ArrayList<>(0);
		List<Product> searchedByCategory = new ArrayList<>(0);
		List<Product> searchedByPrice = new ArrayList<>(0);
		
		if (color != "") {
			searchedByColor = service.findProductByColor(filter);
		}
		
		if (type != "") {
			searchedByType = service.findProductByType(filter);
		}
		
		if (category != "") {
			searchedByCategory = service.findProductByCategory(filter);
		}
		
		if (minPrice != "") {
			System.out.println("Minumum price " + minPrice);
			searchedByPrice = service.findProductByPrice(minPrice, maxPrice);
		}
		
		if (maxPrice != "") {
			searchedByPrice = service.findProductByPrice(minPrice, maxPrice);
		}
		
		List<Product> searchedProducts = new ArrayList<>();
		Stream.of(searchedByColor, searchedByType, searchedByCategory, searchedByPrice).forEach(searchedProducts::addAll);
		
		model.addAttribute("resultsOfSearch", searchedProducts);
		model.addAttribute("filter", filter);
		model.addAttribute("filtering", filtering);
		
		return "dropDownFilters";
	}
	
	
	
	private void populateModel(ModelMap model) {
		model.addAttribute("products", service.findAllProducts());
	}


}
