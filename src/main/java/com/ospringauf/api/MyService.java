package com.ospringauf.api;

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

	
	@Context UriInfo uriInfo;
	

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public Response getText() {
			

		return Response.ok().entity("Hello World").build();			
	}
	

}
