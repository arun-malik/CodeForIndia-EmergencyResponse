package com.codeforindia.emrgncyres.apiresource;


import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.codeforindia.emrgncyres.exception.*;
import com.codeforindia.emrgncyres.model.*;
import com.codeforindia.emrgncyres.service.UserOperationService;
import com.codeforindia.emrgncyres.service.impl.UserOperationsServiceImpl;
import com.yammer.metrics.annotation.Timed;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserAPI {

	UserOperationService userOperationService;

	@Path("/ping")
	@GET
	@Timed(name = "test-api-working-heartbeat")  
	public Response getStatus() {
		return Response.status(200).entity("pong").build();
	}
	
	@GET
	@Timed(name = "finAllUsers")  
	public Response getUsers() {
		try{
			userOperationService = new UserOperationsServiceImpl();
			List<UserDetails> lstUsers = userOperationService.getUsers();
		
			return Response.status(200).entity(lstUsers).build();
		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{
			
		}
	}
	
	@POST
	@Timed(name = "createUser")  
	public Response createUsers(@Valid UserDetails userToCreate) {
		try{
			if(null != userToCreate){
				if(null!= userToCreate.getMobileNumber()){
					
					userOperationService = new UserOperationsServiceImpl();
					UserDetails createdUser = userOperationService.createUser(userToCreate);
					return Response.status(200).entity(createdUser).build();
				}
				else
				{
					throw new CompulsoryFieldException("Mobile Numner is a Mandatory field");
				}
			}else
			{
				throw new InvalidInputException("Please check the imput data");
			}
			
		
			
		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{
			
		}
	}
	
	
	@POST
	@Path("/{userID}")
	@Timed(name = "updateUser")  
	public Response updateUser(@Valid UserDetails userToUpdate,@PathParam("userID") Integer userID ) {
		try{
			if(null != userID){
				if(null!= userToUpdate.getMobileNumber()){
					
					userOperationService = new UserOperationsServiceImpl();
					UserDetails createdUser = userOperationService.updateUser(userToUpdate);
					return Response.status(200).entity(createdUser).build();
				}
				else
				{
					throw new CompulsoryFieldException("Mobile Numner is a Mandatory field");
				}
			}else
			{
				throw new InvalidInputException("Please pass UserID in URL");
			}
			
		
			
		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{
			
		}
	}
	
	
	@GET
	@Path("/{userID}")
	@Timed(name = "getUser")  
	public Response getUserDetails(@PathParam("userID") Integer userID ) {
		try{
			if(null != userID){
				
					userOperationService = new UserOperationsServiceImpl();
					UserDetails createdUser = userOperationService.getUser(userID);
					return Response.status(200).entity(createdUser).build();
				
			}else
			{
				throw new InvalidInputException("Please pass UserID in URL");
			}
			
		
			
		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{
			
		}
	}

}
