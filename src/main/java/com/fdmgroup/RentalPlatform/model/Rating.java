package com.fdmgroup.RentalPlatform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private Integer userValue;
	  
	  private Integer productValue;
	  
	  public Integer getUserValue() {
		return userValue;
	}

	public void setUserValue(Integer userValue) {
		this.userValue = userValue;
	}

	public Integer getProductValue() {
		return productValue;
	}

	public void setProductValue(Integer productValue) {
		this.productValue = productValue;
	}

	@ManyToOne
	  private User user;
	  
	  @ManyToOne
	  private Product product;
	  
	  public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Rating() {};
	  
	public Rating(Long id, User user, Product product, Integer productValue, Integer userValue) {
		super();
		this.id = id;
		this.productValue = productValue;
		this.userValue = userValue;
		this.user = user;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
//
//	@Override
//	public String toString() {
//		return "Rating [id=" + id + ", value=" + value + ", user=" + user + ", product=" + product + "]";
//	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", userValue=" + userValue + ", productValue=" + productValue + ", user=" + user
				+ ", product=" + product + "]";
	}

//	@Override
//	public String toString() {
//		return "Rating [id=" + id + ", value=" + value + ", user=" + user + "]";
//	}

}
