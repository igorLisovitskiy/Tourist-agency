package com.lisovitskiy.pojos;

public class Hotel {
	private int hotelId;
	private String name;
	private String address;
	private String city;

	public Hotel(int hotelId, String name, String address, String city) {
		this.hotelId = hotelId;
		this.name = name;
		this.address = address;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
