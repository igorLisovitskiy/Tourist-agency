package com.lisovitskiy.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lisovitskiy.facades.RegistrationFacade;

/**
 * @author i.lisovitskyi Servlet implementation class LoginController A
 *         controller for handling user registration
 */
@WebServlet(name = "RegistrationContlroller", urlPatterns = "/signing", loadOnStartup = 1)
public class RegistrationContlroller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RegistrationFacade rf = new RegistrationFacade();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("https://tomcat.apache.org/");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("s_username");
		String mail = request.getParameter("s_mail");
		String password = request.getParameter("s_password");
		String birthday = request.getParameter("s_birthday");
		rf.registerUser(username, mail, password, birthday);
		
		
		//request.setAttribute("loginError","Incorrect password");
		

		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
