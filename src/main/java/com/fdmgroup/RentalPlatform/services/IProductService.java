package com.fdmgroup.RentalPlatform.services;

import java.util.List;

import com.fdmgroup.RentalPlatform.model.Product;

public interface IProductService {
	Product findByProductName(String productName);
	List<Product> findAllProducts();
	void createNewProduct(Product product);
	Product findProductById(int id); //throws ProductNotFoundException;
	void deleteProduct(int id); //throws ProductNotFoundException;
	List<Product> filterProducts(String filter);
}
