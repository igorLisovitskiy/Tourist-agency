package com.lisovitskiy.facades;

public class RegistrationFacade {
	private UserFacade uFacade = new UserFacade();

	public boolean registerUser(String username, String mail, String password, String birthday) {
		return uFacade.createUser(username, mail, password, birthday, 2);
	}
}
