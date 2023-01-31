package com.fdmgroup.RentalPlatform.util;

public class Filtering {
	
	private String color;
	private String type;
	private String category;
	//private String timeFrame;
	private String minPrice;
	private String maxPrice;
	
	public Filtering(String color, String type, String category, String minPrice, String maxPrice) {
		super();
		this.color = color;
		this.type = type;
		this.category = category;
		//this.timeFrame = timeFrame;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	public Filtering() {
		super();
		this.color = "";
		this.type = "";
		this.category = "";
		//this.timeFrame = "";
		this.minPrice = "";
		this.maxPrice = "";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
// TO BE FINISHED LATER WHEN BOOKING WILL WORK
//	public String getTimeFrame() {
//		return timeFrame;
//	}
//
//	public void setTimeFrame(String timeFrame) {
//		this.timeFrame = timeFrame;
//	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}


}
