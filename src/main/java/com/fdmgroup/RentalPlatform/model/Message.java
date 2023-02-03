package com.fdmgroup.RentalPlatform.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private User buyer;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Lob
	private String messageText;
	
	private String subject;

	private Date timeSent;

	private boolean sentByBuyer = false;

	private boolean isRead;

	public Message() {

	}

	public Message(User owner, User buyer, String message, Product product) {
		super();
		this.owner = owner;
		this.buyer = buyer;
		this.messageText = message;
		this.product = product;
	}

	public Message(String message) {
		this.messageText = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSubject() {
		if (this.product != null) {
			return product.getProductName();
		}
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String message) {
		this.messageText = message;
	}

	public Date getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(Date timeSent) {
		this.timeSent = timeSent;
	}

	public void setStartDate(Date startDate) {
		this.timeSent = startDate;
	}

	public boolean isSentByBuyer() {
		return sentByBuyer;
	}

	public void setSentByBuyer(boolean sentByBuyer) {
		this.sentByBuyer = sentByBuyer;
	}

	public boolean getisRead() {
		return isRead;
	}

	public void setisRead(boolean isRead) {
		this.isRead = isRead;
	}

}
