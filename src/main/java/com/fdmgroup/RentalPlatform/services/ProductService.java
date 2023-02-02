package com.fdmgroup.RentalPlatform.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.repository.ProductRepository;
import com.fdmgroup.RentalPlatform.util.FileUploadUtil;

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
//		
//		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        product.setPhotos(fileName);
//         
//        Product savedProduct = repo.save(product);
// 
//        String uploadDir = "user-photos/" + savedProduct.getId();
// 
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
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
			List<Product> filteredByType = repo.findByTypeIgnoreCase(filters);
			List<Product> filteredByCatogory = repo.findByCategoryIgnoreCase(filters);
			List<Product> filteredByColor = repo.findByColorIgnoreCase(filters);
			
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

	@Override
	public List<Product> findProductByColor(String filter) {
		return repo.findByColorIgnoreCase(filter);
	}

	@Override
	public List<Product> findProductByType(String filter) {
		return repo.findByTypeIgnoreCase(filter);
	}

	@Override
	public List<Product> findProductByCategory(String filter) {
		return repo.findByCategoryIgnoreCase(filter);
	}

//	@Override
//	public List<Product> findProductByTimeFrame(String filter) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Product> findProductByPrice(String min, String max) {
		return repo.findByPriceBetween(Double.parseDouble(min), Double.parseDouble(max));
	}
	
	@Override
	public List<Product> findProductByMinPrice(String min) {
		return repo.findByPriceGreaterThanEqual(Double.parseDouble(min));
	}
	
	@Override
	public List<Product> findProductByMaxPrice(String max) {
		return repo.findByPriceLessThanEqual(Double.parseDouble(max));
	}
	

}
