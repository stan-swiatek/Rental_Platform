package com.fdmgroup.RentalPlatform.services;

import java.util.List;
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
		Optional<Product> optProduct = repo.findByProductName(productName);
		
		return optProduct.orElse(new Product("default product"));
	}

	@Override
	public List<Product> findAllProducts() {
		return repo.findAll();
	}

	@Override
	public void createNewProduct(Product product) {
		System.out.println("dodano");
		repo.save(product);
		
	}

	@Override
	public Product findProductById(int id) {
		Optional<Product> optProduct = repo.findById(id);
		
		return optProduct.orElse(new Product("default product"));
	}

	@Override
	public void deleteProduct(int id) {
		repo.delete(findProductById(id));
		
	}

//	@Override
//	public List<Product> filterProducts(String filter) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
