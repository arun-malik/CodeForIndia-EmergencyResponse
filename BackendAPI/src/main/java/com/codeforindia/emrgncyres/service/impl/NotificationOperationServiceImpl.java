package com.codeforindia.emrgncyres.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.codeforindia.emrgncyres.model.NotificationHistory;
import com.codeforindia.emrgncyres.model.UserDetails;
import com.codeforindia.emrgncyres.service.NotificationOperationService;

public class NotificationOperationServiceImpl implements NotificationOperationService{

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	Query query;

	public NotificationOperationServiceImpl(){
		entityManagerFactory=Persistence.createEntityManagerFactory("EmergencyResponse");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	public NotificationHistory saveNotification(NotificationHistory notification) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(notification);
		entityManager.getTransaction().commit();


		return notification;
	}

	public List<NotificationHistory> getNotifications() {
		
		query = entityManager.createNamedQuery("NotificationHistory.findAll");
		List<NotificationHistory>  lstQueryRes = query.getResultList();
		
		return lstQueryRes;
	}

}
