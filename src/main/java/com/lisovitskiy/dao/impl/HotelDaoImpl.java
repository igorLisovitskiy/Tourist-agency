package com.lisovitskiy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisovitskiy.dao.HotelDao;
import com.lisovitskiy.pojos.Hotel;
import com.lisovitskiy.utilities.db.ConnectionManager;

public class HotelDaoImpl implements HotelDao {
	private final static String CREATE_HOTEL = "INSERT INTO hotels (`name`, `address`, `checkin`, `checkout`, `nights`, `price`, `city_id`, `city_name`) VALUES(?, ?, ?, ?, ?, ?, (SELECT city_id FROM cities WHERE city_name = ?), ?)";
	private final static String DELETE_HOTEL = "DELETE FROM hotels WHERE hotel_id = ?";

	private final static String UPDATE_HOTEL = "UPDATE `protraveldb`.`hotels` SET `hotel_id`= ?, `name`= ?, `address`= ?, `checkin`= ?, `checkout`= ?, `nights`= ?, `price`= ?, `city_id`= ?, `city_name`= ? WHERE `hotel_id`= ?;";
	private final static String SELECT_HOTEL_BY_ID = "SELECT * FROM hotels WHERE hotel_id = ?";

	private final static String SELECT_ALL_HOTELS = "SELECT * FROM hotels";
	private final static String SELECT_HOTEL_BY_ORDER_ID = "SELECT h.hotel_id, h.name, h.address, h.checkin, h.checkout, h.nights, h.price, h.city_id, h.city_name\r\n"
			+ "FROM orders o\r\n" + "INNER JOIN hotels h\r\n" + "WHERE o.hotel_id = ?;";

	public List<Hotel> getHotelsByOrderId(int orderId) {
		List<Hotel> hotelList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_HOTEL_BY_ORDER_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				hotelList.add(getHotelFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hotelList;
	}

	// Utility methods
	private static Hotel getHotelFromDb(ResultSet rs) throws SQLException {
		return new Hotel(rs.getInt("hotel_id"), rs.getString("name"), rs.getString("address"), rs.getDate("checkin"),
				rs.getDate("checkout"), rs.getInt("nights"), rs.getInt("price"), rs.getString("city_name"));
	}

	@Override
	public Hotel getHotelById(int yourId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getHotelsByPeriod(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createHotel(String name, String address, String checkin, String checkout, int nights, int price,
			String city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotel(int hotelId, String name, String address, String checkin, String checkout, int nights,
			int price, String city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		// TODO Auto-generated method stub
		return false;
	}
}
