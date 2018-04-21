package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Hotel;

public interface HotelDao {
	Hotel getHotelById(int yourId);

	List<Hotel> getAllHotels();

	List<Hotel> getHotelsByOrderId(int orderId);

	List<Hotel> getHotelsByPeriod(String start, String end);

	boolean createHotel(String name, String address, String checkin, String checkout, int nights, int price,
			String city);

	boolean updateHotel(int hotelId, String name, String address, String checkin, String checkout, int nights,
			int price, String city);

	boolean deleteHotel(int hotelId);
}
