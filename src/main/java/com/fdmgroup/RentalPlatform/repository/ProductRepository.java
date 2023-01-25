package com.fdmgroup.RentalPlatform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.RentalPlatform.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByProductName(String productName);
}
