package com.lisovitskiy.facades;

import com.lisovitskiy.dao.impl.UserDaoImpl;
import com.lisovitskiy.pojos.User;
import com.lisovitskiy.utilities.PasswordService;

public class RegistrationFacade {
	private UserDaoImpl user = new UserDaoImpl();
	public User registerUser(String username, String password) {
		PasswordService pws = new PasswordService();
		//encrypt the password to check against what's stored in DB
		String encryptedPass = pws.encrypt(password);
		return user.authenticateUser(username, encryptedPass);
	}
}