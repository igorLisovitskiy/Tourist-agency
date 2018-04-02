package com.lisovitskiy.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lisovitskiy.facades.LoginFacade;
import com.lisovitskiy.pojos.User;

/**
 * @author i.lisovitskyi Servlet implementation class LoginController A
 *         controller for handling user  authentication and login
 */
@WebServlet(name = "LoginController", urlPatterns = "/login", loadOnStartup = 1)
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private String url;
	private int loginAttempts;
	private LoginFacade lf = new LoginFacade();

	public LoginController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		// get the number of logins
		if (session.getAttribute("loginattempts") == null) {
			loginAttempts = 0;
		}

		// exceeded logings
		if (loginAttempts > 2) {
			String errorMessage = "Error: Number of Login Attempts Exceeded";
			req.setAttribute("errorMessage", errorMessage);
			//TODO ajax here
			url = "jsp/index.jsp";
		} else {
			// proceed
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			User user = lf.authentificatedUser(username, password);
			if (user != null) {
				// invalidate current session, then get new session for our user (prevents
				// session hijacking)
				session.invalidate();
				session = req.getSession(true);
				session.setAttribute("user", user);
				url = "dashboard";
			} else {
				String errorMessage = "Error: Unrecognized Username or Password<br>Login attampts remaining: "
						+ (3 - (loginAttempts));
				req.setAttribute("errorMessage", errorMessage);
				// track login attempts (prevents brute force attacks)
				session.setAttribute("loginAttempts", loginAttempts);
				url = "login";
			}
			resp.sendRedirect(url);
		}
	}
}
