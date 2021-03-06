package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Booking;

public interface BookingDao {
	Booking getBookingById(int yourId);

	List<Booking> getAllBookings();

	List<Booking> getBookingByOrderId(int orderId);

	boolean deleteBooking(int bookingId);

	boolean updateBooking(int bookingId, int orderId, int hotelId, String checkin, String checkout, int price,
			int nights);

	boolean createBooking(int orderId, int hotelId, String checkin, String checkout, int price, int nights);

}
