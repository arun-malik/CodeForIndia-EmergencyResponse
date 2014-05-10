package com.codeforindia.emrgncyres.apiresource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codeforindia.emrgncyres.exception.InvalidInputException;
import com.codeforindia.emrgncyres.model.IncidentReported;
import com.codeforindia.emrgncyres.model.NotificationHistory;
import com.codeforindia.emrgncyres.service.*;
import com.codeforindia.emrgncyres.service.impl.IncidentReportOperationServiceImpl;
import com.codeforindia.emrgncyres.service.impl.NotificationOperationServiceImpl;
import com.yammer.metrics.annotation.Timed;

@Path("/notification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationAPI {

	NotificationOperationService notificationOperationService;
	
	@POST
	@Timed(name = "saveNotification")  
	public Response saveNotification(@Valid NotificationHistory notification) {
		try{
			if(null != notification){

				notificationOperationService = new NotificationOperationServiceImpl();
				NotificationHistory notificationRecorded = notificationOperationService.saveNotification(notification);
				return Response.status(200).entity(notificationRecorded).build();

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
	@Timed(name = "getAllNotification")  
	public Response getNotifications() {
		try{
			notificationOperationService = new NotificationOperationServiceImpl();
			List<NotificationHistory> allNotification = notificationOperationService.getNotifications();
			return Response.status(200).entity(allNotification).build();



		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{

		}
	}
}
