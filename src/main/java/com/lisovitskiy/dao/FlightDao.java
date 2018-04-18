package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Flight;

public interface FlightDao {
	Flight getFlightById(int yourId);

	List<Flight> getAllFlights();

	List<Flight> getFlightsByPeriod(String start, String end);

	boolean createFlight(String from, String to, String departure, int flightTime, int price);

	boolean updateFlight(int flightId, String from, String to, String departure, int flightTime, int price);

	boolean deleteFlight(int flightId);
}
