package com.codeforindia.emrgncyres.service;

import java.util.List;

import com.codeforindia.emrgncyres.model.Tracking;
import com.codeforindia.emrgncyres.model.TrackingHistory;

public interface CheckInHistoryOperationService {

	public List<TrackingHistory> getUsersAllLocation(Integer userID);
	
}
