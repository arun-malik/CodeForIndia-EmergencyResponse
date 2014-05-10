package com.codeforindia.emrgncyres.service.impl;

import org.springframework.stereotype.Service;

import com.codeforindia.emrgncyres.model.Admin;
import com.codeforindia.emrgncyres.repo.AdminRepo;
import com.codeforindia.emrgncyres.service.AdminOperationService;

import javax.annotation.Resource;

// This class and package is responsible to perform operations on Admin Table ( Model ) 
// using AdminRepo ( extends JPA Repo )

@Service
public class AdminOperationServiceImpl implements AdminOperationService {

	@Resource
	private AdminRepo adminRepo;
	
	public Admin getAdminDetails(String userName) {
		
		
		return adminRepo.findByUsername(userName);
		
	}

}
