package com.fdmgroup.RentalPlatform.services;

import java.util.Optional;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.Role;
import com.fdmgroup.RentalPlatform.repository.ProductRepository;

public class ProductService implements IProductService {
	
	private ProductRepository repo;
	
	@Override
	public Product findByProductName(String productName) {
		Optional<Product> optRole = repo.findByProductName(productName);
		
		return optRole.orElse(new Product("default role"));
	}

}
