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
import com.codeforindia.emrgncyres.service.IncidentReportOperationService;
import com.codeforindia.emrgncyres.service.impl.IncidentReportOperationServiceImpl;
import com.yammer.metrics.annotation.Timed;

@Path("/incident")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncidentReportAPI {

	IncidentReportOperationService incidentOperationService;

	@POST
	@Timed(name = "createIncident")  
	public Response recordIncident(@Valid IncidentReported incident) {
		try{
			if(null != incident){

				incidentOperationService = new IncidentReportOperationServiceImpl();
				IncidentReported trackRecord = incidentOperationService.saveIncident(incident);
				return Response.status(200).entity(trackRecord).build();

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
			incidentOperationService = new IncidentReportOperationServiceImpl();
			List<IncidentReported> allIncidents = incidentOperationService.getAllIncident();
			return Response.status(200).entity(allIncidents).build();



		}catch( Exception ex){
			return Response.status(400).entity("Error "+ ex.toString()).build();
		}
		finally{

		}
	}

}
