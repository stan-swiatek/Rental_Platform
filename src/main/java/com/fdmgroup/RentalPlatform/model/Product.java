package com.fdmgroup.RentalPlatform.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name, description, category;
	
	private BigDecimal price;
	
	@OneToOne
	private User owner;
	
	private Date availavbleFrom, availableTo;
	
	private boolean isAvailable;
	
	private double rating;
}
