package com.lisovitskiy.pojos;

import java.util.Date;

public class Rental {
	private int rentalId;
	private String name;

	public Rental(int rentalId, String name, String description, Date from, Date to, int price) {
		super();
		this.rentalId = rentalId;
		this.name = name;
		this.description = description;
		this.from = from;
		this.to = to;
		this.price = price;
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

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private String description;
	private Date from;
	private Date to;
	private int price;

}
