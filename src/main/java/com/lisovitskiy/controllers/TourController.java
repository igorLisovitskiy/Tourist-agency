package com.lisovitskiy.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lisovitskiy.facades.TourFacade;
import com.lisovitskiy.pojos.Tour;


@WebServlet(name = "TourController", urlPatterns = "/details", loadOnStartup = 1)
public class TourController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourFacade tourFacade = new TourFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Tour tour = tourFacade.getTourById(id);
			request.setAttribute("tour", tour);
			request.getRequestDispatcher("jsp/tour.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/login").forward(request, response);
			System.out.println("as");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
