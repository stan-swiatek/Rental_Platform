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

	private String productName, description, category;

	private BigDecimal price;

	@OneToOne
	private User owner;

	private Date availavbleFrom, availableTo;

	private boolean isAvailable;

	private double rating;

	public Product() {
	}

	public Product(String name) {
		super();
		this.productName = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getAvailavbleFrom() {
		return availavbleFrom;
	}

	public void setAvailavbleFrom(Date availavbleFrom) {
		this.availavbleFrom = availavbleFrom;
	}

	public Date getAvailableTo() {
		return availableTo;
	}

	public void setAvailableTo(Date availableTo) {
		this.availableTo = availableTo;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
