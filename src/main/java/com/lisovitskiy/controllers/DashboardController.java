package com.lisovitskiy.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DashboardController", urlPatterns = "/dashboard", loadOnStartup = 1)
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		if (session.getAttribute("user") != null) {
			req.getRequestDispatcher("jsp/userdashboard.jsp").forward(req, resp);
		} else {
			//won't happen every not logged attempt for /dashboard is filtered by LoggedFilter
			//resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		if (session.getAttribute("user") != null) {
			resp.sendRedirect("jsp/userdashboard.jsp");
		} else {
			resp.sendRedirect("/");
		}
	}
}
