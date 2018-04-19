package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Rental;

public interface RentalDao {
	Rental getRentalById(int yourId);

	List<Rental> getAllRentals();

	List<Rental> getRentalsByPeriod(String start, String end);

	boolean createRental(String name, String description, String fromDate, String toDate, int price, String city);

	boolean updateRental(int rentalId, String name, String description, String fromDate, String toDate, int price, String city);

	boolean deleteRental(int rentalId);
}
