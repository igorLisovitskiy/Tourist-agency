package com.lisovitskiy.facades;

import java.util.List;

import com.lisovitskiy.dao.impl.FlightDaoImpl;
import com.lisovitskiy.pojos.Flight;

public class FlightFacade {
	FlightDaoImpl fDao = new FlightDaoImpl();
	
	public List<Flight> getFlights(){
		return fDao.getAllFlights();
	}
	public Flight getFlightById(int id) {
		return fDao.getFlightById(id);
	}
	public List<Flight> getFlightsByPeriod(String from, String to) {
		return fDao.getFlightsByPeriod(from, to);
	}
	public boolean createFlight(String departureDate, String fromCity, String toCity, int flightTime, int price) {
		return fDao.createFlight(departureDate, fromCity, toCity, flightTime, price);
	};
	public boolean deleteFlight(int flightId) {
		return fDao.deleteFlight(flightId);
	}

}
