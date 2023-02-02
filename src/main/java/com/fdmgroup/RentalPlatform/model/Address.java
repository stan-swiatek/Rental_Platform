package com.fdmgroup.RentalPlatform.model;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Address {
	

	@Id
	@GeneratedValue
	private Integer id;
	
	private String country, city, street, postalCode;
	
	private Integer buildingNumber, flatNumber;

	public Address() {}

	public Address(String country, String city, String street, String postalCode, Integer buildingNumber,
			Integer flatNumber) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
		this.buildingNumber = buildingNumber;
		this.flatNumber = flatNumber;
	}
	
	public Address(String country, String city, String street, String postalCode, Integer buildingNumber) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
		this.buildingNumber = buildingNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(Integer buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public Integer getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(Integer flatNumber) {
		this.flatNumber = flatNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buildingNumber, city, country, flatNumber, postalCode, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(buildingNumber, other.buildingNumber) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(flatNumber, other.flatNumber)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(street, other.street);
	}
	@Override
	public String toString() {
		return  street + " " + getBuildingNumber()+ "/" + getFlatNumber()+ ", "+ city;
	}
	
	
	
}
