package com.ospringauf.api.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(Arquillian.class)
@RunAsClient
/**
 * Arquillian black-box test for REST endpoints.
 * Starts a local Payara server in "micro managed" mode and tests the endpoints in Arquillian's "Client Mode"
 * 
 * Run in Maven build:
 * - make sure the env-var MICRO_JAR / property microJar is set in the maven-surefire plugin,
 *   if possible as a pointer to the payara jar in the local M2
 *   
 * Run in Eclipse / JUnit:
 * - create a run configuration for the unit test and define env.var. MICRO_JAR as the path of the local 
 *   payara-micro jar.
 *
 */
public class ArquillianApiTest {

	@ArquillianResource // injected service URL for test container
	private URL base;
	

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive war = ShrinkWrap
				.create(WebArchive.class, "my-microservice.war")
				.addPackages(true, "com.ospringauf.api")
				// default beans cfg for automatic CDI
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"), "beans.xml")
				// exchange web.xml to use H2 database (URL, other parameters)
//				.addAsWebInfResource(new File("src/test/resources/arquillian/web.xml"), "web.xml")
				;
		
		return war;
	}

	
	@Test
	@InSequence(1)
	public void getText(@ArquillianResteasyResource("api/text") WebTarget webTarget) throws Exception {
		System.out.println("CALL: " + webTarget.getUri());
		final Response resp = webTarget.request().get();

		System.out.println(resp);
		assertEquals(Status.OK.getStatusCode(), resp.getStatus());
		
		System.out.println(resp.readEntity(String.class));
	}


}
