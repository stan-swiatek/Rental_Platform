package com.fdmgroup.RentalPlatform.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
	@Autowired
	ProductService productService = new ProductService();
	
	@BeforeEach
	public void dropTables() {
		List<Product> productsToDelete = productService.findAllProducts();
		for (Product product : productsToDelete) {
			productService.deleteProduct(product.getId());
		}
	}
	
	@Test
	public void test_findProductByNameWhenExists() {
		Product product = new Product();
		product.setProductName("name");
		productService.createNewProduct(product);
		
		assertEquals(product.getId(), productService.findByProductName("name").getId());
	}
	
	@Test
	public void test_findNoProductByNameWhenNoneExists() {
		Product product = new Product();
		product.setProductName("name1");
		productService.createNewProduct(product);
		
		assertNotEquals(product.getId(), productService.findByProductName("name2").getId());
	}
}
