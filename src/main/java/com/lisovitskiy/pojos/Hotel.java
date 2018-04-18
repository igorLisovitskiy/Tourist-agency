package com.lisovitskiy.pojos;

import java.util.Date;

public class Hotel {
	private int hotelId;
	private String name;
	private String address;
	private Date checkin;
	private Date checkout;
	private int nights;

	public Hotel(int hotelId, String name, String address, Date checkin, Date checkout, int nights, int price) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.address = address;
		this.checkin = checkin;
		this.checkout = checkout;
		this.nights = nights;
		this.price = price;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int price;

}
