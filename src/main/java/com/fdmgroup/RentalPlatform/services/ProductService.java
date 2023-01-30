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
	public List<Product> filterProducts(String combinedFilter) {
		List<Product> filteredByType = new ArrayList<>();
		List<Product> filteredByCatogory = new ArrayList<>();
		List<Product> filteredByColor = new ArrayList<>();
		for (String filter : combinedFilter.split(" ")) {
		filteredByType = repo.findByTypeIgnoreCaseContaining(filter);
		filteredByCatogory = repo.findByCategoryIgnoreCaseContaining(filter);
		filteredByColor = repo.findByColorIgnoreCaseContaining(filter);
		}		
		List<Product> filteredProducts = new ArrayList<>();
		Stream.of(filteredByType, filteredByCatogory, filteredByColor).forEach(filteredProducts::addAll);
		return filteredProducts;
	}

}
