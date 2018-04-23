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
	private final static String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_USER_ID = "SELECT o.order_id, u.user_id, mail AS user_email, t.tour_id, t.`name` AS tour_name, t.price AS tour_price, "
			+ "f.flight_id, f.price AS flight_price, h.hotel_id, oh.price AS hotel_price, r.rental_id, orental.price AS rental_price "
			+ "FROM orders o INNER JOIN users u ON o.user_id = u.user_id LEFT JOIN orders_tours ot ON o.order_id = ot.order_id "
			+ "LEFT JOIN tours t ON t.tour_id = ot.tour_id LEFT JOIN orders_flights of ON o.order_id = of.order_id "
			+ "LEFT JOIN flights f ON f.flight_id = of.flight_id LEFT JOIN orders_hotels oh ON o.order_id = oh.order_id "
			+ "LEFT JOIN hotels h ON h.hotel_id = oh.hotel_id LEFT JOIN orders_rental orental ON o.order_id = orental.order_id "
			+ "LEFT JOIN rental r ON r.rental_id = orental.rental_id WHERE o.user_id = ? GROUP BY o.user_id";

	private final static String SELECT_ALL_ORDERS = "SELECT o.order_id, u.user_id, mail AS user_email, t.tour_id, t.`name` AS tour_name, t.price AS tour_price, "
			+ "f.flight_id, f.price AS flight_price, h.hotel_id, oh.price AS hotel_price, r.rental_id, orental.price AS rental_price "
			+ "FROM orders o INNER JOIN users u ON o.user_id = u.user_id LEFT JOIN orders_tours ot ON o.order_id = ot.order_id "
			+ "LEFT JOIN tours t ON t.tour_id = ot.tour_id LEFT JOIN orders_flights of ON o.order_id = of.order_id "
			+ "LEFT JOIN flights f ON f.flight_id = of.flight_id LEFT JOIN orders_hotels oh ON o.order_id = oh.order_id "
			+ "LEFT JOIN hotels h ON h.hotel_id = oh.hotel_id LEFT JOIN orders_rental orental ON o.order_id = orental.order_id "
			+ "LEFT JOIN rental r ON r.rental_id = orental.rental_id GROUP BY o.user_id";

	private final static String SELECT_ORDER_BY_ID = "SELECT o.order_id, u.user_id, mail AS user_email, t.tour_id, t.`name` AS tour_name, t.price AS tour_price, "
			+ "f.flight_id, f.price AS flight_price, h.hotel_id, oh.price AS hotel_price, r.rental_id, orental.price AS rental_price "
			+ "FROM orders o INNER JOIN users u ON o.user_id = u.user_id LEFT JOIN orders_tours ot ON o.order_id = ot.order_id "
			+ "LEFT JOIN tours t ON t.tour_id = ot.tour_id LEFT JOIN orders_flights of ON o.order_id = of.order_id "
			+ "LEFT JOIN flights f ON f.flight_id = of.flight_id LEFT JOIN orders_hotels oh ON o.order_id = oh.order_id "
			+ "LEFT JOIN hotels h ON h.hotel_id = oh.hotel_id LEFT JOIN orders_rental orental ON o.order_id = orental.order_id "
			+ "LEFT JOIN rental r ON r.rental_id = orental.rental_id WHERE o.order_id = ? GROUP BY o.order_id";

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
		int userId = rs.getInt("user_id");
		String userEmail = rs.getString("user_email");
		int orderId = rs.getInt("order_id");
		int tourId = rs.getInt("tour_id");
		String tourName = rs.getString("tour_name");
		;
		int tourPrice = rs.getInt("tour_price");
		int flightId = rs.getInt("flight_id");
		int flightPrice = rs.getInt("flight_price");
		int hotelId = rs.getInt("hotel_id");
		int hotelPrice = rs.getInt("hotel_price");
		int rentalId = rs.getInt("rental_id");
		int rentalPrice = rs.getInt("rental_price");

		return new Order(new Order.OrderBuilder(userId, orderId, userEmail).setTourId(tourId).setTourId(tourId)
				.setTourName(tourName).setTourPrice(tourPrice).setFlightId(flightId).setFlightPrice(flightPrice)
				.setHotelId(hotelId).setHotelPrice(hotelPrice).setRentalId(rentalId).setRentalPrice(rentalPrice));
	}
}
