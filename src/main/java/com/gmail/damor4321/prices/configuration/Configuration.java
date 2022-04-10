package com.gmail.damor4321.prices.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import lombok.Data;


// TODO: Auto-generated Javadoc
/**
 * Instantiates a new configuration.
 */
@Data
@EnableAsync
@org.springframework.context.annotation.Configuration
@ComponentScan("com.gmail.damor4321")
public class Configuration {

	/** The service name. */
	@Value("${service.name:}")
	private String serviceName;

	/** The service password. */
	@Value("${service.password:}")
	private String servicePassword;

	/** The security enabled. */
	@Value("${service.securityEnabled:}")
	private String securityEnabled;

	/** The url. */
	@Value("${custom-datasource-data.url:}")
	private String url;

	/** The username. */
	@Value("${custom-datasource-data.username:}")
	private String username;

	/** The password. */
	@Value("${custom-datasource-data.password:}")
	private String password;

}



