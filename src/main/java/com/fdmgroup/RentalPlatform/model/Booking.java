package com.fdmgroup.RentalPlatform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private Integer id;

}
