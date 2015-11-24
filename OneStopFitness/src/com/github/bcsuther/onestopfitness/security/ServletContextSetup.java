package com.github.bcsuther.onestopfitness.security;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextSetup implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                //LOG.log(Level.INFO, String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                //LOG.log(Level.SEVERE, String.format("Error deregistering driver %s", driver), e);
            }

        }
	}

}
