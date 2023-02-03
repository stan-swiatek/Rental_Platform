package com.fdmgroup.RentalPlatform.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {


	@Id
	@GeneratedValue
	private Integer id;

	private String productName, description, category, type, color, pickUpLocation;

	private Double price;

	@OneToOne
	private User owner;

	private boolean isAvailable;

	private double rating;
	
	@ElementCollection

	private List<String> photos;
	
	
	public Product() {
	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}


	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		if(this.photos== null) {
			this.photos = new ArrayList<String>();
		}
		this.photos.add(photos);
	}


	@Override
	public String toString() {
		return "Product [productName=" + productName + ", owner=" + owner + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, color, description, isAvailable, owner, photos, pickUpLocation, price,
				productName, rating, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(color, other.color)
				&& Objects.equals(description, other.description) && isAvailable == other.isAvailable
				&& Objects.equals(owner, other.owner) && Objects.equals(photos, other.photos)
				&& Objects.equals(pickUpLocation, other.pickUpLocation) && Objects.equals(price, other.price)
				&& Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating)
				&& Objects.equals(type, other.type);
	}
}
