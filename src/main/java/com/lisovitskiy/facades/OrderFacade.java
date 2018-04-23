package com.lisovitskiy.facades;

import java.util.List;

import com.lisovitskiy.dao.impl.OrderDaoImpl;
import com.lisovitskiy.pojos.Order;

public class OrderFacade {
	OrderDaoImpl oDao = new OrderDaoImpl();
	
	public List<Order> getOrders(){
		return oDao.getAllOrders();
	}

	public boolean deleteOrder(int orderId) {
		return oDao.deleteOrder(orderId);
		
	}
}
