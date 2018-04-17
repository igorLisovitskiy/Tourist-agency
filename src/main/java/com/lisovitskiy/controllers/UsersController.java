package com.lisovitskiy.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lisovitskiy.facades.UserFacade;

@WebServlet(name = "UsersController", urlPatterns = "/users", loadOnStartup = 1)
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserFacade userFacade = new UserFacade();
		session = request.getSession();
		if (session.getAttribute("user") != null) {
			request.getRequestDispatcher("jsp/users.jsp").forward(request, response);
		} else {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
		}

	//	List<User> daysByLessons = userFacade.getDaysByLessons(Integer.parseInt(request.getParameter("lessons-5")));
	//	request.setAttribute("daysByLessons", daysByLessons);
		try {
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
