package com.codeforindia.emrgncyres.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.codeforindia.emrgncyres.model.IncidentReported;
import com.codeforindia.emrgncyres.model.NotificationHistory;
import com.codeforindia.emrgncyres.service.IncidentReportOperationService;

public class IncidentReportOperationServiceImpl implements IncidentReportOperationService {

	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	Query query;

	public IncidentReportOperationServiceImpl(){
		entityManagerFactory=Persistence.createEntityManagerFactory("EmergencyResponse");
		entityManager=entityManagerFactory.createEntityManager();
	}
	public IncidentReported saveIncident(IncidentReported incident) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(incident);
		entityManager.getTransaction().commit();


		return incident;
	}

	public List<IncidentReported> getAllIncident() {
		
		query = entityManager.createNamedQuery("IncidentReported.findAll");
		List<IncidentReported>  lstQueryRes = query.getResultList();
		
		return lstQueryRes;
	}

}
