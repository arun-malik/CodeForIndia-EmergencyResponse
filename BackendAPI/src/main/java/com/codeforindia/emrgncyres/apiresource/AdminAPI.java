package com.codeforindia.emrgncyres.apiresource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codeforindia.emrgncyres.model.Admin;
import com.codeforindia.emrgncyres.service.AdminOperationService;
import com.codeforindia.emrgncyres.service.impl.AdminOperationServiceImpl;
import com.yammer.metrics.annotation.Timed;


@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminAPI {
	
	
	AdminOperationService adminOperationService;
	
	@Path("/ping")
	@GET
	@Timed(name = "test-api-working-heartbeat")  
	public Response getStatus() {
		return Response.status(200).entity("pong").build();
	}
	
	
	@Path("/{username}")
	@GET
	@Timed(name = "admin")  
	public Response getAdmin(@PathParam("username") String userName) {
		try{
//			adminOperationService = new AdminOperationServiceImpl();
//			Admin adminUser = adminOperationService.getAdminDetails(userName);
		
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("EmergencyResponse");
			EntityManager em=emf.createEntityManager();
			
			Query qm = em.createNamedQuery("Admin.findByUsername");
			
			
			return Response.status(200).entity("").build();
		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{
			
		}
	}

}
