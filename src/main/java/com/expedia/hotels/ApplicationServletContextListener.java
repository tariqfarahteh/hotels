package com.expedia.hotels;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.expedia.hotels.exception.BusinessException;

public class ApplicationServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * Initialises Startup functionality on webapp startup
	 * 
	 * @author Tariq
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Startup.init();
		} catch (BusinessException e) {
			Log.fatal(this, e.getMessage());
		}
	}

}
