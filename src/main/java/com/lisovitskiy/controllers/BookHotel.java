package com.lisovitskiy.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lisovitskiy.facades.BookingFacade;

@WebServlet(name = "BookHotel", urlPatterns = "/dashboard/book/hotel", loadOnStartup = 1)
public class BookHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingFacade bFacade = new BookingFacade();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int orderId = Integer.parseInt((String) request.getAttribute("id"));
			int hotelId = Integer.parseInt((String) request.getAttribute("id"));
			String checkin = (String) request.getAttribute("checkin");
			String checkout = (String) request.getAttribute("checkout");
			int price = Integer.parseInt((String) request.getAttribute("price"));
			int nights = Integer.parseInt((String) request.getAttribute("nights"));
			bFacade.createBooking(orderId, hotelId, checkin, checkout, price, nights);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookingId = Integer.parseInt((String) req.getAttribute("bookingId"));
		bFacade.deleteBooking(bookingId);
	}
	
}
