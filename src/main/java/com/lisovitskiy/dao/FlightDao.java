package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Flight;

public interface FlightDao {
	Flight getFlightById(int yourId);

	List<Flight> getAllFlights();

	List<Flight> getFlightsByPeriod(String start, String end);

	boolean createFlight(String departureDate, String fromCity, String toCity, int flightTime, int price);

	boolean updateFlight(int flightId, String departureDate, String fromCity, String toCity, int flightTime, int price);

	boolean deleteFlight(int flightId);

	boolean orderFlight(Integer orderId, int flightId);

}
