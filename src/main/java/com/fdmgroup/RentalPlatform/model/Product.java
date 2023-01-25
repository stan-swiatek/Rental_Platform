package com.fdmgroup.RentalPlatform.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name, description;
	
	private BigDecimal price;
	
	
	
}
