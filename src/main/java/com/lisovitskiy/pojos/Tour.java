package com.lisovitskiy.pojos;

import java.util.Date;

public class Tour {
	private String tourName;
	private String description;
	private double price;
	private Date startDate;
	private Date endDate;

	public Tour(String tourName, String description, double price, Date startDate, Date endDate) {
		this.tourName = tourName;
		this.description = description;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
