package com.codeforindia.emrgncyres.main;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.codeforindia.emrgncyres.apiresource.AdminAPI;
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
	}

}
