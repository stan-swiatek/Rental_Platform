package com.fdmgroup.RentalPlatform.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
		String[] filtersArray = filter.split(" ");
		List<List<Product>> results = new ArrayList<List<Product>>();
		
		for (String filters : filtersArray) {
			List<Product> filteredByProductName = repo.findByProductNameIgnoreCaseContaining(filters);
			List<Product> filteredByType = repo.findByTypeIgnoreCaseContaining(filters);
			List<Product> filteredByCatogory = repo.findByCategoryIgnoreCaseContaining(filters);
			List<Product> filteredByColor = repo.findByColorIgnoreCaseContaining(filters);
			
			List<Product> filteredProducts = new ArrayList<>();
			Stream.of(filteredByProductName, filteredByType, filteredByCatogory, filteredByColor).forEach(filteredProducts::addAll);
			results.add(filteredProducts);
		}
		
		List<Product> finalFilteredProducts = new ArrayList<Product>();
		finalFilteredProducts.addAll(results.get(0));
	    for (ListIterator<List<Product>> iter = results.listIterator(0); iter.hasNext(); ) {
	    	finalFilteredProducts.retainAll(iter.next());
	    }
		
		return finalFilteredProducts;
	}
	

}
