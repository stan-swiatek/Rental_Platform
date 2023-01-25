package com.fdmgroup.RentalPlatform.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Offer {
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private User owner;
	
	@OneToOne
	private Product product;
	
	private Date startDate, endDate;
	//Check if available
	private String offerStatus;
	
}
