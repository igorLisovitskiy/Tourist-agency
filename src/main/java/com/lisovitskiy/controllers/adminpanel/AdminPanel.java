package com.lisovitskiy.controllers.adminpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdminPanel", urlPatterns = "/adminpanel", loadOnStartup = 1)
public class AdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		if (session.getAttribute("user") != null) {
			req.getRequestDispatcher("/jsp/admin.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
