package com.lisovitskiy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.List;

import com.lisovitskiy.dao.UserDao;
import com.lisovitskiy.pojos.User;
import com.lisovitskiy.utilities.PasswordService;
import com.lisovitskiy.utilities.db.ConnectionManager;

public class UserDaoImpl implements UserDao {
	private final static String CREATE_USER = " INSERT INTO users(username, password, mail, birthday, role_id) VALUES(?, ?, ?, ?, ?)";
	private final static String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
	private final static String AUTHENTIFICATE_USER = "SELECT * FROM users WHERE username = ? AND password = ?";

	@Override
	public User getUserById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authenticateUser(String username, String password) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PasswordService pws = new PasswordService();
		//encrypt the password to check against what's stored in DB
		String encryptedPass = pws.encrypt(password);
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(AUTHENTIFICATE_USER);
			ps.setString(1, username);
			ps.setString(2, encryptedPass);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password").toCharArray(),
						rs.getString("mail"), rs.getDate("birthday"), rs.getInt("role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean createUser(String username, String mail, String password, String birthday, int roleId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		PasswordService pws = new PasswordService();
		// encrypt the password to check against what's stored in DB
		String encryptedPass = pws.encrypt(password);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.parse(birthday, formatter);
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_USER);
			ps.setString(1, username);
			ps.setString(2, encryptedPass);
			ps.setString(3, mail);
			ps.setDate(4, sqlDate);
			ps.setInt(5, roleId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

}
