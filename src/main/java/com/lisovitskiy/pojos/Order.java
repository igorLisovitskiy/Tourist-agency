package com.lisovitskiy.pojos;

public class Order {
	private int orderId;
	private int userId;
	private int tourId;
	private int rentalId;
	private int flightId;
	private int hotelId;
	
	public int getOrderId() {
		return orderId;
	}
	public Order(int orderId, int userId, int tourId, int rentalId, int flightId, int hotelId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.tourId = tourId;
		this.rentalId = rentalId;
		this.flightId = flightId;
		this.hotelId = hotelId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	

}
