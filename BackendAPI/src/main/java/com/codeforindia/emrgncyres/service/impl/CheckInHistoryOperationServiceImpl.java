package com.codeforindia.emrgncyres.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.codeforindia.emrgncyres.model.Tracking;
import com.codeforindia.emrgncyres.model.TrackingHistory;
import com.codeforindia.emrgncyres.service.CheckInHistoryOperationService;

public class CheckInHistoryOperationServiceImpl implements CheckInHistoryOperationService {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	Query query;
	
	public List<TrackingHistory> getUsersAllLocation(Integer userID) {
		query = entityManager.createNamedQuery("TrackingHistory.findAllByUser");
		List<TrackingHistory>  lstQueryRes = query.getResultList();

		//List<UserDetails> userList = (UserDetails) lstQueryRes.toArra;

		return lstQueryRes;
	}
}
