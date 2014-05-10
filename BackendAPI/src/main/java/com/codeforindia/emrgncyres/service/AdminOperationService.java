package com.codeforindia.emrgncyres.service;

import com.codeforindia.emrgncyres.model.Admin;


/// This interface and package is responsible to list down all operations can be performed on Admin 
/// This interface is implemented in AdminOperationServiceImpl

public interface AdminOperationService {

	public Admin getAdminDetails(String userName);
	
}
