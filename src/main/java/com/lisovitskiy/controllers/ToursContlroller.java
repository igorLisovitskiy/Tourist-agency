package com.lisovitskiy.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lisovitskiy.facades.RegistrationFacade;


@WebServlet(name = "ToursContlroller", urlPatterns = "/tours", loadOnStartup = 1)
public class ToursContlroller extends HttpServlet {
	private HttpSession session;

	private static final long serialVersionUID = 1L;
	RegistrationFacade rf = new RegistrationFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();
		if (session.getAttribute("user") != null) {
			request.getRequestDispatcher("jsp/tours.jsp").forward(request, response);
		} else {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		rf.registerUser(username, mail, password, birthday);

		try {
			request.getRequestDispatcher("/login").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
