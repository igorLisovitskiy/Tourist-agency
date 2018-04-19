package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Order;

public interface OrderDao {
	Order getOrderById(int orderId);

	List<Order> getAllOrders();
	List<Order> getOrdersByUserId(int userId);
	boolean createOrder(int userId,int tourId);
	boolean orderHotel(int orderId, int hotelId);
	boolean orderFlight(int orderId, int flightId);
	boolean orderRental(int orderId, int rentalId);
	
	boolean discardHotel(int orderId, int hotelId);
	boolean discardFlight(int orderId, int flightId);
	boolean discardRental(int orderId, int rentalId);

	boolean deleteOrder(int orderId);
}
