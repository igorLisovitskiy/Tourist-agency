package com.lisovitskiy.facades;

import java.util.List;

import com.lisovitskiy.dao.impl.RentalDaoImpl;
import com.lisovitskiy.pojos.Rental;

public class RentalFacade {
	RentalDaoImpl rDao = new RentalDaoImpl();
	
	public List<Rental> getRentals(){
		return rDao.getAllRentals();
	}
	public Rental getRentalById(int id) {
		return rDao.getRentalById(id);
	}
	public boolean createRental(String name, String description, String fromDate, String toDate, int price, String city) {
		return rDao.createRental(name, description, fromDate, toDate, price, city);
	}
	public boolean deleteRental(int rentalId) {
		return rDao.deleteRental(rentalId);
	}
	public List<Rental> getRentalByCity(String city) {
		return rDao.getRentalsByCityName(city);
		
	}

}
