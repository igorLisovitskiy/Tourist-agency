package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Hotel;

public interface HotelDao {
	Hotel getHotelById(int yourId);

	List<Hotel> getAllHotels();

	List<Hotel> getHotelsByOrderId(int orderId);

	List<Hotel> getHotelsByCity(String cityName);

	boolean deleteHotel(int hotelId);

	boolean createHotel(String name, String address, String city);

	boolean updateHotel(int hotelId, String name, String address, String city);

}
