package com.codeforindia.emrgncyres.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codeforindia.emrgncyres.apiresource.AdminAPI;
import com.codeforindia.emrgncyres.apiresource.IncidentReportAPI;
import com.codeforindia.emrgncyres.apiresource.NotificationAPI;
import com.codeforindia.emrgncyres.apiresource.TrackingAPI;
import com.codeforindia.emrgncyres.apiresource.TrackingHistoryAPI;
import com.codeforindia.emrgncyres.apiresource.UserAPI;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class EmergencyResponseService  extends Service<EmergencyResponseServiceConfiguration> {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	

	public static void main(String[] args) throws Exception {
		new EmergencyResponseService().run(args);
	}

	@Override
	public void initialize(
			Bootstrap<EmergencyResponseServiceConfiguration> bootstrap) {
		bootstrap.setName("emergencyResponse-service");
		bootstrap.addBundle(new ViewBundle());
		bootstrap.addBundle(new AssetsBundle());

	}

	@Override
	public void run(EmergencyResponseServiceConfiguration configuration,
			Environment environment) throws Exception {


		environment.addResource(AdminAPI.class);
		environment.addResource(UserAPI.class);
		
		environment.addResource(TrackingAPI.class);
		environment.addResource(TrackingHistoryAPI.class);
		
		environment.addResource(NotificationAPI.class);
		environment.addResource(IncidentReportAPI.class);
		
	}

}
