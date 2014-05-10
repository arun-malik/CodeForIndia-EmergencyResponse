package com.codeforindia.emrgncyres.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.codeforindia.emrgncyres.model.Tracking;
import com.codeforindia.emrgncyres.model.UserDetails;
import com.codeforindia.emrgncyres.service.CheckInOperationService;

public class CheckInOperationServiceImpl implements CheckInOperationService {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	Query query;

	public CheckInOperationServiceImpl(){
		entityManagerFactory=Persistence.createEntityManagerFactory("EmergencyResponse");
		entityManager=entityManagerFactory.createEntityManager();
	}

	public Tracking getUsersLastLocation(Integer userID) {

		query = entityManager.createNamedQuery("Tracking.findTrackByKey").setParameter("key", userID);
		List<Tracking>  lstQueryRes = query.getResultList();

		Tracking tracking = (Tracking) lstQueryRes.toArray()[0];
		return tracking;

	}

	public Tracking checkInLocation(Tracking checkinParam) {

		entityManager.getTransaction().begin();
		entityManager.persist(checkinParam);
		entityManager.getTransaction().commit();

		return checkinParam;
	}

	public List<Tracking> getAllLastLocation() {

		query = entityManager.createNamedQuery("Tracking.findAll");
		List<Tracking>  lstQueryRes = query.getResultList();

		return lstQueryRes;
	}


}
