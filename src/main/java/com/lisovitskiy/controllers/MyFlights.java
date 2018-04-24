package com.lisovitskiy.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lisovitskiy.facades.OrderFacade;
import com.lisovitskiy.facades.FlightFacade;
import com.lisovitskiy.pojos.Flight;
import com.lisovitskiy.pojos.User;

@WebServlet(name = "MyFlights", urlPatterns = {"/dashboard/book/flight", "/profile/myflights"}, loadOnStartup = 1)
public class MyFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightFacade flightFacade = new FlightFacade();
	OrderFacade orderFacade = new OrderFacade();
	HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Integer> flightIdlist = orderFacade.getOrdersByUserId(user.getId()).stream().map(o -> o.getFlightId()).collect(Collectors.toList());
		List<Flight> flights = flightIdlist.stream().map(id -> flightFacade.getFlightById(id)).collect(Collectors.toList());
		flights = flights.stream().filter( Objects::nonNull).collect(Collectors.toList());
		String json = new Gson().toJson(flights);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("user"));
		int flightlId = Integer.parseInt(request.getParameter("id"));
		session = request.getSession();
		Integer orderId = (Integer) session.getAttribute("orderId");
		if (orderId == null) {
			orderId = orderFacade.createOrder(userId);
			session.setAttribute("order", orderId);
		}
		flightFacade.orderFlight(orderId, flightlId);
	}

}
