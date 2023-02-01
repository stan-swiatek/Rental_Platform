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
	  
	  private Integer value;
	  
	  @ManyToOne
	  private User user;
	  
	  public Rating() {};
	  
	public Rating(Long id, Integer value, User user) {
		super();
		this.id = id;
		this.value = value;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", value=" + value + ", user=" + user + "]";
	}

}
