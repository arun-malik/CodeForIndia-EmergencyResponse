package com.codeforindia.emrgncyres.service;

import java.util.List;

import com.codeforindia.emrgncyres.model.NotificationHistory;

public interface NotificationOperationService {
	
	public NotificationHistory saveNotification(NotificationHistory notification);
	public List<NotificationHistory> getNotifications();

}
