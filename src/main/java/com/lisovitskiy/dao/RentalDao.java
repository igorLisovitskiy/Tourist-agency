package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Rental;

public interface RentalDao {
	Rental getRentalById(int yourId);

	List<Rental> getAllRentals();

	List<Rental> getRentalsByPeriod(String start, String end);

	boolean createRental(String name, String description, String from, String to, int price);

	boolean updateRental(int rentalId, String name, String description, String from, String to, int price);

	boolean deleteRental(int rentalId);
}
