package com.fdmgroup.RentalPlatform.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product findByProductName(String productName) {
		Optional<Product> optRole = repo.findByProductName(productName);
		
		return optRole.orElse(new Product("default role"));
	}

}
