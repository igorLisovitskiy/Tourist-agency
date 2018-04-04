package com.lisovitskiy.pojos;

public class Order {
	private int orderId;
	private int userId;
	private int tourId;

	public Order(int orderId, int userId, int tourId) {
		this.orderId = orderId;
		this.userId = userId;
		this.tourId = tourId;
	}

	public int getOrderId() {
		return orderId;
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

}
