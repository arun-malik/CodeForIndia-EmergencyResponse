package com.codeforindia.emrgncyres.apiresource;



import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codeforindia.emrgncyres.exception.CompulsoryFieldException;
import com.codeforindia.emrgncyres.exception.InvalidInputException;
import com.codeforindia.emrgncyres.model.Tracking;
import com.codeforindia.emrgncyres.service.CheckInOperationService;
import com.codeforindia.emrgncyres.service.impl.CheckInOperationServiceImpl;
import com.yammer.metrics.annotation.Timed;

@Path("/checkIn")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrackingAPI {

	CheckInOperationService checkInOperationService;

	@POST
	@Timed(name = "checkInUser")  
	public Response checkInUser(@Valid Tracking checkInrecord) {
		try{
			if(null != checkInrecord){
				if(null!= checkInrecord.getLat()|| null!= checkInrecord.getLong_() || null!= checkInrecord.getModifiedDateTime() || null != checkInrecord.getUserDeatil()){

					checkInOperationService = new CheckInOperationServiceImpl();
					Tracking trackRecord = checkInOperationService.checkInLocation(checkInrecord);
					return Response.status(200).entity(trackRecord).build();
				}
				else
				{
					throw new CompulsoryFieldException("Error : Missing Mandatory field.");
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


	@GET
	@Path("/{userID}")
	@Timed(name = "lastCheckInForUser")  
	public Response lastCheckInForUser(@PathParam("userID") Integer userID ) {
		try{
			if(null != userID){

				checkInOperationService = new CheckInOperationServiceImpl();
				Tracking lastCheckedIn = checkInOperationService.getUsersLastLocation(userID);
				return Response.status(200).entity(lastCheckedIn).build();

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
	@Timed(name = "allLastCheckIn")  
	public Response allLastCheckIn() {
		try{

			checkInOperationService = new CheckInOperationServiceImpl();
			List<Tracking> listTrack = checkInOperationService.getAllLastLocation();
			return Response.status(200).entity(listTrack).build();


		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{

		}
	}

}
