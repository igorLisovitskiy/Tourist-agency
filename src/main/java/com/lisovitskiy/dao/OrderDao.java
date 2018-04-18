package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.Order;

public interface OrderDao {
	Order getOrderById(int orderId);

	List<Order> getAllOrders();

	boolean createOrder(int userId, int tourId);

	boolean updateOrder(int orderId, int userId, int tourId);

	boolean deleteOrder(int orderId);
}
