package com.lisovitskiy.pojos;

import java.util.List;

public class Order {
	// required
	private int orderId;
	private User user;
	// optional
	private List<Tour> tours;
	private List<Hotel> hotels;
	private List<Flight> flights;
	private List<Rental> rentals;

	public Order(OrderBuilder builder) {
		this.orderId = builder.orderId;
		this.user = builder.user;
		this.tours = builder.tours;
		this.hotels = builder.hotels;
		this.flights = builder.flights;
		this.rentals = builder.rentals;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public List<Tour> getTours() {
		return tours;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public static class OrderBuilder {
		// required
		private int orderId;
		private User user;
		// optional
		private List<Tour> tours;
		private List<Hotel> hotels;
		private List<Flight> flights;
		private List<Rental> rentals;

		public OrderBuilder(int orderId, User user) {
			this.orderId = orderId;
			this.user = user;

		}

		public OrderBuilder setUser(User user) {
			this.user = user;
			return this;
		}

		public OrderBuilder setTours(List<Tour> tours) {
			this.tours = tours;
			return this;
		}

		public OrderBuilder setHotels(List<Hotel> hotels) {
			this.hotels = hotels;
			return this;
		}

		public OrderBuilder setFlights(List<Flight> flights) {
			this.flights = flights;
			return this;
		}

		public OrderBuilder setRentals(List<Rental> rentals) {
			this.rentals = rentals;
			return this;
		}
	}


}
