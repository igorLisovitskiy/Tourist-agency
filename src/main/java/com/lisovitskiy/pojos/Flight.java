package com.lisovitskiy.pojos;

import java.util.Date;

public class Flight {

	private int flightID;
	private String from;
	private String to;
	private Date departureDate;

	public Flight(int flightID, String from, String to, Date departure, int flightTime, int price) {
		super();
		this.flightID = flightID;
		this.from = from;
		this.to = to;
		this.departureDate = departure;
		this.flightTime = flightTime;
		this.price = price;
	}

	private int flightTime;

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDeparture() {
		return departureDate;
	}

	public void setDeparture(Date departure) {
		this.departureDate = departure;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int price;

}
