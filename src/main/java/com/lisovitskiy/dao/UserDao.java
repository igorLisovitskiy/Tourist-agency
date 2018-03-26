package com.lisovitskiy.dao;

import java.util.List;

import com.lisovitskiy.pojos.User;

public interface UserDao {
	User authenticateUser(String login, String password);
	User getUserById();
	List<User> getAllUsers();
	boolean createUser(String username, String password, String mail, String dateOfBirth, int roleId);
}
