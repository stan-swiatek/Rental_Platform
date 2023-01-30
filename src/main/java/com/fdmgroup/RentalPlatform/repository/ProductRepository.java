package com.fdmgroup.RentalPlatform.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByProductName(String productName);
	List<Product> findByProductNameIgnoreCaseContaining(String filter);
	List<Product> findByTypeIgnoreCaseContaining(String filter);
	List<Product> findByCategoryIgnoreCaseContaining(String filter);
	List<Product> findByColorIgnoreCaseContaining(String filter);
	//List<Product> findByPriceIgnoreCaseContaining(String filter);
	
}
