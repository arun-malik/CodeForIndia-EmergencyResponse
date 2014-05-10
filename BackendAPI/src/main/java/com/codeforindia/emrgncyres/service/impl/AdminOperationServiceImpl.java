package com.codeforindia.emrgncyres.service.impl;

import org.springframework.stereotype.Service;

import com.codeforindia.emrgncyres.model.Admin;
import com.codeforindia.emrgncyres.service.AdminOperationService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

// This class and package is responsible to perform operations on Admin Table ( Model ) 
// using AdminRepo ( extends JPA Repo )

@Service
public class AdminOperationServiceImpl implements AdminOperationService {
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	Query query;
	
	public AdminOperationServiceImpl(){
		 entityManagerFactory=Persistence.createEntityManagerFactory("EmergencyResponse");
		 entityManager=entityManagerFactory.createEntityManager();
	}

//	@Resource
//	private AdminRepo adminRepo;
	
	public Admin getAdminDetails(String userName) {
		
		query = entityManager.createNamedQuery("Admin.findByUsername").setParameter("username", userName);
		List lstQueryRes = query.getResultList();
		
		Admin user = (Admin) lstQueryRes.toArray()[0];
		return user;
	}

}
