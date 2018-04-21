package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.User;

public interface UserDao {
	User authenticateUser(String login, String password);

	List<User> getAllUsers();

	User getUserById(int id);

	boolean createUser(String username, String password, String mail, String birthday, int roleId);

	boolean deleteUser(int userId);

	boolean updateUser(int userId, String username, String password, String mail, String birthday, int roleId);

	User getUserByOrderId(int orderId);

}
