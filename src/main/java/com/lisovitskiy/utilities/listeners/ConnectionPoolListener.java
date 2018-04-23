package com.lisovitskiy.utilities.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lisovitskiy.utilities.db.ConnectionManager;

/**
 * Application Lifecycle Listener implementation class ConnectionPoolListener
 *
 */
@WebListener
public class ConnectionPoolListener implements ServletContextListener {
	private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/protravelDb?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	ServletContext servletContext;
	
    public ConnectionPoolListener() {

    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	System.out.println("destroyed");
    
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	servletContext = sce.getServletContext();
    	
    	//db initialization
    	Connection con = null;
		try {
			ConnectionManager.setUpConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
			con = ConnectionManager.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	servletContext.setAttribute("Connection", con);
    	ContextManager.setServletContext(servletContext);
    }
	
}