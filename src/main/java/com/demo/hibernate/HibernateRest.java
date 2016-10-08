package com.demo.hibernate;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/hibernate")
public class HibernateRest {

	@GET
	@Path("/demo/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Just checking") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();
	}
	
}
