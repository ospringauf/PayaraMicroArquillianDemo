package com.ospringauf.api;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class MyApp extends Application {
	static Logger log = Logger.getLogger(MyApp.class.getName());

	/**
	 * Initialize the web application
	 */
	@PostConstruct
	public void initApp() {
//		initLogging();
	}


}
