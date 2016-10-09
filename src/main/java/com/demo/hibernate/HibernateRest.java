package com.demo.hibernate;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.models.Employee;

@Path("/hibernate")
public class HibernateRest {

	@GET
	@Path("/demo/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Just checking") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;
		
		testDB();

		return Response.status(200).entity(output).build();
	}
	
	public void testDB(){
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employee emp = new Employee("MrRogers");
		session.save(emp);

		session.getTransaction().commit();
		session.close();
		
	}
	
}
