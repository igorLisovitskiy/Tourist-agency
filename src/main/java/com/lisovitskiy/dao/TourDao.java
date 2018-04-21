package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Tour;

public interface TourDao {
	Tour getTourById(int yourId);

	List<Tour> getAllTours();

	List<Tour> getToursByPeriod(String start, String end);

	boolean createTour(String name, String description, String start, String end, int price, String language);

	boolean updateTour(int tourId, String name, String description, String start, String end, int price,
			String language);

	boolean deleteTour(int tourId);

	List<Tour> getToursByOrderId(int orderId);
}
