package com.codeforindia.emrgncyres.apiresource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codeforindia.emrgncyres.exception.InvalidInputException;
import com.codeforindia.emrgncyres.model.TrackingHistory;
import com.codeforindia.emrgncyres.service.CheckInHistoryOperationService;
import com.codeforindia.emrgncyres.service.impl.CheckInHistoryOperationServiceImpl;
import com.yammer.metrics.annotation.Timed;

@Path("/checkInHistory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TrackingHistoryAPI {

	CheckInHistoryOperationService checkInHsitoryOperationService;

	@GET
	@Timed(name = "checkInUserHistory")  
	@Path("/{userID}")
	public Response lastCheckInForUser(@PathParam("userID") Integer userID ) {
		try{
			if(null != userID){

				checkInHsitoryOperationService = new CheckInHistoryOperationServiceImpl();
				List<TrackingHistory> userCheckInHistory = checkInHsitoryOperationService.getUsersAllLocation(userID);
				return Response.status(200).entity(userCheckInHistory).build();

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
