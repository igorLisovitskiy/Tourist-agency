package com.lisovitskiy.facades;

import java.util.List;

import com.lisovitskiy.dao.impl.UserDaoImpl;
import com.lisovitskiy.pojos.User;

public class UserFacade {
	UserDaoImpl uDao = new UserDaoImpl();
	
	public List<User> getUsers(){
		return uDao.getAllUsers();
	}
	public User getuserById(int id) {
		return uDao.getUserById(id);
	}
	public boolean createUser(String username, String mail, String password, String birthday, int role) {
		return uDao.createUser(username, mail, password, birthday, role);
	}
	public boolean updateUser(int userId, String username, String password, String mail, String birthday, int roleId) {
		return uDao.updateUser(userId, username, password, mail, birthday, roleId);
	}
	public boolean deleteUser(int userId) {
		return uDao.deleteUser(userId);
	}
}
