package com.ospringauf.api;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/api")
@RequestScoped
public class MyService {
	static Logger log = Logger.getLogger(MyService.class.getName());

	
	@Context UriInfo uriInfo;
	

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public Response getText() {
			

		return Response.ok().entity("Hello World").build();			
	}
	

}
