package com.lisovitskiy.facades;

import java.util.List;

import com.lisovitskiy.dao.impl.OrderDaoImpl;
import com.lisovitskiy.pojos.Order;

public class OrderFacade {
	OrderDaoImpl oDao = new OrderDaoImpl();
	
	public List<Order> getOrders(){
		return oDao.getAllOrders();
	}


	public boolean updateOrder(int userId, String username, String password, String mail, String birthday, int roleId) {
		return false;

	}
	public boolean deleteOrder(int userId) {
		return false;
		
	}
}
