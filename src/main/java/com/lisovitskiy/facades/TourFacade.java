package com.lisovitskiy.facades;

import java.util.List;

import com.lisovitskiy.dao.impl.TourDaoImpl;
import com.lisovitskiy.pojos.Tour;

public class TourFacade {
	TourDaoImpl tDao = new TourDaoImpl();
	
	public List<Tour> getTours(){
		return tDao.getAllTours();
	}
	public Tour getTourById(int id) {
		return tDao.getTourById(id);
	}
	
	public List<Tour> getToursByPeriod(String start, String end){
		return tDao.getToursByPeriod(start, end);
	}
	public boolean createTour(String name, String description, String start, String end, int price, String language) {
		return tDao.createTour(name, description, start, end, price, language);
	}

}
