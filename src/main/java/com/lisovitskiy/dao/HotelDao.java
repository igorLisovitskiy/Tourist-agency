package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Hotel;

public interface HotelDao {
	Hotel getHotelById(int yourId);

	List<Hotel> getAllHotels();

	List<Hotel> getHotelsByPeriod(String start, String end);

	boolean createHotel(String name, String address, String checkin, String checkout, int nights, int price);

	boolean updateHotel(int hotelId, String address, String checkin, String checkout, int nights, int price);

	boolean deleteHotel(int hotelId);
}
