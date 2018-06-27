package com.ospringauf.api;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@LoginConfig(authMethod = "MP-JWT")
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
