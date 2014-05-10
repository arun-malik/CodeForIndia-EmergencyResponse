package com.codeforindia.emrgncyres.service;

import java.util.List;

import com.codeforindia.emrgncyres.model.*;

public interface CheckInOperationService {
	
	public Tracking getUsersLastLocation(Integer userID);
	public Tracking checkInLocation(Tracking checkinParam);
	public List<Tracking> getAllLastLocation() ;

}
