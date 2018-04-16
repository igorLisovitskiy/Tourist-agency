package com.lisovitskiy.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lisovitskiy.pojos.User;
import com.lisovitskiy.utilities.AuthService;

/**
 * Servlet Filter implementation class LoggedFilter
 */
@WebFilter(urlPatterns = "/dashboard/*")
public class LoggedFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoggedFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		boolean isRemembered = AuthService.getRememberMeCookie(httpRequest).isPresent();
	
		if(session.getAttribute("user") == null) {
			httpRequest.setAttribute("displayLogin", "block;");
			httpRequest.getRequestDispatcher("jsp/index.jsp").forward(httpRequest, httpResponse);
		}else {
			httpRequest.getRequestDispatcher("/login").forward(httpRequest, httpResponse);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
