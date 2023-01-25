package com.fdmgroup.RentalPlatform.services;

import com.fdmgroup.RentalPlatform.model.Product;

public interface IProductService {
	Product findByProductName(String productName);
}
