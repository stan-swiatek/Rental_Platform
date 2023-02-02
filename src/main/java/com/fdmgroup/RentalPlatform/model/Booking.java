package com.fdmgroup.RentalPlatform.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookingDate = new Date();
	
	private String status;
	
	private Boolean accepted;
	
	private Integer rating;
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Override
	public String toString() {
		return "<br>status: "+status+
				"<br>startDate: "+startDate+
				"<br>endDate: "+endDate+
				"<br>product_id: "+product.getId()+
				"<br>username: "+user.getUsername()+"|"+user.getId()+
				"<br>booking time: "+bookingDate+
				"<br>booking_id: "+id;
	}
	
	// old comments
//	private User owner, requester;
//	private Product product;
//	private String offerStatus, rolename;
//	private Date startDate, endDate;
//	
//	
//	public Booking() {
//		
//	}
//
//
//	public User getOwner() {
//		return owner;
//	}
//
//
//	public void setOwner(User owner) {
//		this.owner = owner;
//	}
//
//
//	public User getRequester() {
//		return requester;
