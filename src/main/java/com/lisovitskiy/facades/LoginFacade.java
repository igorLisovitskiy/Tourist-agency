package com.lisovitskiy.facades;

import com.lisovitskiy.dao.impl.UserDaoImpl;
import com.lisovitskiy.pojos.User;

public class LoginFacade {
	private UserDaoImpl user = new UserDaoImpl();

	public User authentificatedUser(String username, String password) {
		return user.authenticateUser(username, password);
	}
}
