package com.lisovitskiy.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lisovitskiy.facades.RegistrationFacade;
import com.lisovitskiy.facades.TourFacade;
import com.lisovitskiy.pojos.Tour;


@WebServlet(name = "ToursContlroller", urlPatterns = "/tours", loadOnStartup = 1)
public class ToursContlroller extends HttpServlet {
	private HttpSession session;

	private static final long serialVersionUID = 1L;
	TourFacade tourFacade = new TourFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		List<Tour> tours = tourFacade.getToursByPeriod(start, end);
		String json = new Gson().toJson(tours);
		response.setContentType("application/json");
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	
		//request.setAttribute("tours", json);
		//request.getRequestDispatcher("dashboard").forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		

		try {
			request.getRequestDispatcher("/login").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
