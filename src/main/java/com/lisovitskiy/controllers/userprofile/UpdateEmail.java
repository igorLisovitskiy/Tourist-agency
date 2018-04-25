package com.lisovitskiy.controllers.userprofile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lisovitskiy.facades.UserFacade;
import com.lisovitskiy.pojos.User;


@WebServlet(name = "UpdateEmail", urlPatterns = "/profile/edit/email", loadOnStartup = 1)
public class UpdateEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserFacade uFacade = new UserFacade();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			User user = (User) request.getSession().getAttribute("user");
			Integer id = user.getId();
			String mail = request.getParameter("mail");
			if(id != null && mail != null) {
				uFacade.updateUserMail(id, mail);
				response.sendRedirect("/TouristAgency/logout");
			}
	}

}
