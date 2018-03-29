package com.lisovitskiy.facades;

import com.lisovitskiy.dao.impl.UserDaoImpl;

public class RegistrationFacade {
	private UserDaoImpl user = new UserDaoImpl();

	public boolean registerUser(String username, String mail, String password, String birthday) {
		return user.createUser(username, mail, password, birthday, 2);
	}
}
