package com.lisovitskiy.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lisovitskiy.facades.BookingFacade;
import com.lisovitskiy.facades.HotelFacade;
import com.lisovitskiy.facades.OrderFacade;
import com.lisovitskiy.pojos.Hotel;
import com.lisovitskiy.pojos.Order;
import com.lisovitskiy.pojos.User;

@WebServlet(name = "MyHotels", urlPatterns = {"/dashboard/myhotels", "/profile/myhotels"}, loadOnStartup = 1)
public class MyHotels extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingFacade bookingFacade = new BookingFacade();
	OrderFacade orderFacade = new OrderFacade();
	HotelFacade hotelFacade = new HotelFacade();
	HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Order> userOrders = orderFacade.getOrdersByUserId(user.getId());

		List<Integer> hotelIdslist = userOrders.stream()
				.map(order -> bookingFacade.getBookingsByOrderId(order.getOrderId()))
						.flatMap(Collection::stream).collect(Collectors.toList()).stream()
						.map(booking -> booking.getHotelId()).collect(Collectors.toList());
				
		List<Hotel> hotels = hotelIdslist.stream().map(id -> hotelFacade.getHotelById(id))
				.collect(Collectors.toList());

		String json = new Gson().toJson(hotels);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("user"));
		int hotelId = Integer.parseInt(request.getParameter("id"));
		int price = Integer.parseInt(request.getParameter("price"));
		int nights = Integer.parseInt(request.getParameter("nights"));
		String checkin = (String) request.getAttribute("startDate");
		String checkout = (String) request.getAttribute("endDate");
		
		session = request.getSession();
		Integer orderId = (Integer) session.getAttribute("orderId");
		if(orderId == null) {
			orderId = orderFacade.createOrder(userId);
			session.setAttribute("order", orderId);
		}
		bookingFacade.createBooking(orderId, hotelId, checkin, checkout, price, nights);
		
	}

}
