package com.fdmgroup.RentalPlatform.services;

import java.math.BigDecimal;
import java.util.List;

import com.fdmgroup.RentalPlatform.model.Product;

public interface IProductService {
	Product findByProductName(String productName);
	List<Product> findAllProducts();
	void createNewProduct(Product product);
	Product findProductById(int id); //throws ProductNotFoundException;
	void deleteProduct(int id); //throws ProductNotFoundException;
	List<Product> filterProducts(String filter);
	List<Product> findProductByColor(String filter);
	List<Product> findProductByType(String filter);
	List<Product> findProductByCategory(String filter);
	//List<Product> findProductByTimeFrame(String filter);
	List<Product> findProductByPrice(String min, String max);
	List<Product> findProductByMinPrice(String min);
	List<Product> findProductByMaxPrice(String max);
	
}
