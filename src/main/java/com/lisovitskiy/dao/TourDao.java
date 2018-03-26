package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Tour;

public interface TourDao {
	Tour getTour();
	List<Tour> getAllTours();
}
