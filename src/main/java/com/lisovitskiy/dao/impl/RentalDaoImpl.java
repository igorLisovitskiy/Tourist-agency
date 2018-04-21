package com.lisovitskiy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisovitskiy.dao.RentalDao;
import com.lisovitskiy.pojos.Rental;
import com.lisovitskiy.utilities.db.ConnectionManager;

public class RentalDaoImpl implements RentalDao {
	private final static String CREATE_RENTAL = "INSERT INTO rentals (`name`, `description`, `from`, `to`, `price`, `city_id`, `city_name`) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private final static String DELETE_RENTAL = "DELETE FROM rentals WHERE rental_id = ?";
	private final static String UPDATE_RENTAL = "UPDATE `protraveldb`.`rental` SET `rental_id`= ?, `name`= ?, `description`= ?, `from`= ?, `to`= ?, `price`= ?, `city_id`= ?, `city_name`= ? WHERE `rental_id`= ?;";

	private final static String SELECT_RENTAL_BY_ORDER_ID = "SELECT r.rental_id, r.name, r.description, r.from, r.to, r.price, r.city_id, r.city_name\r\n"
			+ "FROM orders o\r\n" + "INNER JOIN rentals r\r\n" + "WHERE o.rental_id = ?;";

	public List<Rental> getRentalsByOrderId(int orderId) {
		List<Rental> rentalsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_RENTAL_BY_ORDER_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				rentalsList.add(getRentalFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rentalsList;
	}

	// Utility methods
	private static Rental getRentalFromDb(ResultSet rs) throws SQLException {
		return new Rental(rs.getInt("rental_id"), rs.getString("name"), rs.getString("description"), rs.getDate("from"),
				rs.getDate("to"), rs.getInt("price"), rs.getString("city_name"));
	}

	@Override
	public Rental getRentalById(int yourId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rental> getAllRentals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rental> getRentalsByPeriod(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createRental(String name, String description, String fromDate, String toDate, int price,
			String city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRental(int rentalId, String name, String description, String fromDate, String toDate,
			int price, String city) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRental(int rentalId) {
		// TODO Auto-generated method stub
		return false;
	}
}
