package com.codeforindia.emrgncyres.service;

import java.util.List;

import com.codeforindia.emrgncyres.model.IncidentReported;


public interface IncidentReportOperationService {

	public IncidentReported saveIncident(IncidentReported incident);
	public List<IncidentReported> getAllIncident();
	
}
