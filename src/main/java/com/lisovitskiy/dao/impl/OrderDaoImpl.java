package com.lisovitskiy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisovitskiy.dao.OrderDao;
import com.lisovitskiy.pojos.Flight;
import com.lisovitskiy.pojos.Hotel;
import com.lisovitskiy.pojos.Order;
import com.lisovitskiy.pojos.Rental;
import com.lisovitskiy.pojos.Tour;
import com.lisovitskiy.pojos.User;
import com.lisovitskiy.utilities.db.ConnectionManager;

public class OrderDaoImpl implements OrderDao {

	private final static String CREATE_ORDER = "INSERT INTO orders (user_id, tour_id) VALUES(?, ?)";
	private final static String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders WHERE user_id = ?";
	private final static String SELECT_ALL_ORDERS = "SELECT * FROM orders";

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

	// Utility methods
	private static Order getOrderFromDb(ResultSet rs) throws SQLException {

		int orderId = rs.getInt("order_id");
		UserDaoImpl uDao = new UserDaoImpl();
		TourDaoImpl tDao = new TourDaoImpl();
		HotelDaoImpl hDao = new HotelDaoImpl();
		FlightDaoImpl fDao = new FlightDaoImpl();
		RentalDaoImpl rDao = new RentalDaoImpl();

		User user = uDao.getUserByOrderId(orderId);
		List<Tour> tours = tDao.getToursByOrderId(orderId);
		List<Hotel> hotels = hDao.getHotelsByOrderId(orderId);
		List<Flight> flights = fDao.getFlightsByOrderId(orderId);
		List<Rental> rentals = rDao.getRentalsByOrderId(orderId);

		return new Order(new Order.OrderBuilder(orderId, user).setTours(tours).setFlights(flights).setHotels(hotels)
				.setRentals(rentals));
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
