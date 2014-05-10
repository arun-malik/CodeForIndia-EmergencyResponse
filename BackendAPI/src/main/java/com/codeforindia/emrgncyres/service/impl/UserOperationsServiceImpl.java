package com.codeforindia.emrgncyres.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.codeforindia.emrgncyres.model.*;
import com.codeforindia.emrgncyres.service.*;

public class UserOperationsServiceImpl implements UserOperationService {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	Query query;

	public UserOperationsServiceImpl(){
		entityManagerFactory=Persistence.createEntityManagerFactory("EmergencyResponse");
		entityManager=entityManagerFactory.createEntityManager();
	}

	public List<UserDetails> getUsers() {

		query = entityManager.createNamedQuery("UserDetails.findAll");
		List<UserDetails>  lstQueryRes = query.getResultList();

		//List<UserDetails> userList = (UserDetails) lstQueryRes.toArra;

		return lstQueryRes;
	}

	public UserDetails getUser(String usernameOruserCode) {

		query = entityManager.createNamedQuery("findUserByUserCodeOrName").setParameter("username", usernameOruserCode);
		List<UserDetails>  lstQueryRes = query.getResultList();

		UserDetails user = (UserDetails) lstQueryRes.toArray()[0];
		return user;

	}

	public UserDetails getUser(int userDetailsKey) {

		query = entityManager.createNamedQuery("UserDetails.findByUserDetailsKey").setParameter("key", userDetailsKey);
		List<UserDetails>  lstQueryRes = query.getResultList();

		UserDetails user = (UserDetails) lstQueryRes.toArray()[0];
		return user;

	}

	public UserDetails createUser(UserDetails user) {

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		//entityManager.refresh(user);
		//entityManager.flush();

		return user;

	}

	public UserDetails updateUser( UserDetails user) {

		entityManager.getTransaction().begin();

		query = entityManager.createNamedQuery("UserDetails.findByUserDetailsKey").setParameter("key", user.getUserDetailsKey());
		List<UserDetails>  lstQueryRes = query.getResultList();

		UserDetails userForUpdate = (UserDetails) lstQueryRes.toArray()[0];

		userForUpdate.setFirstName(user.getFirstName());
		userForUpdate.setLastName(user.getLastName());
		userForUpdate.setEmergencyContactName(user.getEmergencyContactName());
		userForUpdate.setEmergencyContactNumber(user.getEmergencyContactNumber());
		userForUpdate.setFathersName(user.getFathersName());
		userForUpdate.setFellowPassengerCount(user.getFellowPassengerCount());
		userForUpdate.setMobileNumber(user.getMobileNumber());
		userForUpdate.setMothersName(user.getMothersName());
		userForUpdate.setTrackStatus(user.getTrackStatus());

		entityManager.persist(userForUpdate);
		entityManager.getTransaction().commit();

		return userForUpdate;

	}

	public String deleteUser(UserDetails user) {

//		entityManager.getTransaction().begin();
//		query = entityManager.createNamedQuery("UserDetails.findByUserDetailsKey").setParameter("key", user.getUserDeatilsKey());
//		List<UserDetails>  lstQueryRes = query.getResultList();
//
//		UserDetails userForUpdate = (UserDetails) lstQueryRes.toArray()[0];
//
		return null;
	}

	public UserDetails getUser(Integer userDetailsKey) {

		entityManager.getTransaction().begin();
		query = entityManager.createNamedQuery("UserDetails.findByUserDetailsKey").setParameter("key", userDetailsKey);
		List<UserDetails>  lstQueryRes = query.getResultList();

		UserDetails userForUpdate = (UserDetails) lstQueryRes.toArray()[0];

		return userForUpdate;
	}

}
