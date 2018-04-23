package com.lisovitskiy.pojos;

public class Rental {
	private int rentalId;
	private String name;
	private String description;
	private String city;

	public Rental(int rentalId, String name, String description, String city) {
		this.rentalId = rentalId;
		this.name = name;
		this.description = description;
		this.city = city;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
