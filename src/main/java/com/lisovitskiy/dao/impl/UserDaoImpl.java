package com.lisovitskiy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.lisovitskiy.dao.UserDao;
import com.lisovitskiy.utilities.db.ConnectionManager;
import com.lisovitskiy.pojos.User;

public class UserDaoImpl implements UserDao{
	private final static String CREATE_USER = "INSERT INTO users WHERE username = ?, password = ?, mail = ?, dateOfBirth = ?, role_id = ?";
	
//	INSERT INTO users (username, password, mail, dateOfBirth, role_id)
//	VALUES("New", "saf", "donotsendmeanything@a.com",date('2009-03-01'), 1);
//	
	private final static String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id_user = ?";
	private final static String AUTHENTIFICATE_USER= "SELECT * FROM users WHERE login = ? AND password = ?";
	
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
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(AUTHENTIFICATE_USER);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("id_user"), rs.getString("username"),  rs.getString("password").toCharArray(), rs.getString("mail"), rs.getDate("dateOfBirth"),rs.getInt("id_role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean createUser(String username, String password, String mail, String dateOfBirth, int roleId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_USER);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(2, mail);
			ps.setString(2, dateOfBirth);
			ps.setInt(2, roleId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

}
