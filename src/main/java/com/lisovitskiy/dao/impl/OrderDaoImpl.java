package com.lisovitskiy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisovitskiy.dao.OrderDao;
import com.lisovitskiy.pojos.Order;
import com.lisovitskiy.utilities.db.ConnectionManager;

public class OrderDaoImpl implements OrderDao {

	private final static String CREATE_ORDER = "INSERT INTO orders (user_id, tour_id) VALUES(?, ?)";
	private final static String ORDER_HOTEL = "UPDATE orders SET hotel_id = ? WHERE order_id = ?;";
	private final static String ORDER_FLIGHT = "UPDATE orders SET flight_id = ? WHERE order_id = ?;";
	private final static String ORDER_RENTAL = "UPDATE orders SET rental_id = ? WHERE order_id = ?;";
	private final static String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders WHERE user_id = ?";
	private final static String SELECT_ALL_ORDERS = "SELECT * FROM orders";
	
	private final static String REMOVE_FLIGHT = "UPDATE orders SET flight_id = null WHERE order_id = ?;";
	private final static String REMOVE_HOTEL = "UPDATE orders SET hotel_id = null WHERE order_id = ?;";
	private final static String REMOVE_RENTAL = "UPDATE orders SET rental_id = null WHERE order_id = ?;";

	@Override
	public Order getOrderById(int orderId) {
		Order order = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ORDER_BY_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				order = getOrderFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		List<Order> orderList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ORDER_BY_USER_ID);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				orderList.add(getOrderFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return orderList;
	}
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> orderList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_ORDERS);
			rs = ps.executeQuery();
			while (rs.next()) {
				orderList.add(getOrderFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return orderList;
	}
	
	@Override
	public boolean createOrder(int userId, int tourId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_ORDER);
			ps.setInt(1, userId);
			ps.setInt(2, tourId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_ORDER);
			ps.setInt(1, orderId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean orderHotel(int orderId, int hotelId) {
		return OrderDaoImpl.updateService(orderId, hotelId, ORDER_HOTEL);
	}

	@Override
	public boolean orderFlight(int orderId, int flightId) {
			return OrderDaoImpl.updateService(orderId, flightId, ORDER_FLIGHT);
	}

	@Override
	public boolean orderRental(int orderId, int rentalId) {
		return OrderDaoImpl.updateService(orderId, rentalId, ORDER_RENTAL);
	}

	@Override
	public boolean discardHotel(int orderId, int hotelId) {
		return OrderDaoImpl.updateService(orderId, hotelId, REMOVE_HOTEL);
	}

	@Override
	public boolean discardFlight(int orderId, int flightId) {
		return OrderDaoImpl.updateService(orderId, flightId, REMOVE_FLIGHT);
	}

	@Override
	public boolean discardRental(int orderId, int rentalId) {
		return OrderDaoImpl.updateService(orderId, rentalId, REMOVE_RENTAL);
	}
	
	// Utility methods
	private static Order getOrderFromDb(ResultSet rs) throws SQLException {
		return new Order(rs.getInt("order_id"), rs.getInt("user_id"), rs.getInt("tour_id"), rs.getInt("rental_id"), rs.getInt("flight_id"), rs.getInt("hotel_id"));
	}
	
	private static boolean updateService(int orderId, int serviceId, String statement) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(statement);
			ps.setInt(1, orderId);
			ps.setInt(2, serviceId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
	
}
