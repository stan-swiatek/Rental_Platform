package com.fdmgroup.RentalPlatform.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	@Override
	public List<Product> filterProducts(String filter) {
		List<Product> filteredByType = repo.findByTypeIgnoreCaseContaining(filter);
		List<Product> filteredByCatogory = repo.findByCategoryIgnoreCaseContaining(filter);
		List<Product> filteredByColor = repo.findByColorIgnoreCaseContaining(filter);
		//List<Product> filteredByPrice = repo.findByPriceIgnoreCaseContaining(filter);
		
		List<Product> filteredProducts = new ArrayList<>();
		Stream.of(filteredByType, filteredByCatogory, filteredByColor).forEach(filteredProducts::addAll);
		return filteredProducts;
	}

}
