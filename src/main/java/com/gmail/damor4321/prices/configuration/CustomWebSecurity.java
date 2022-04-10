package com.gmail.damor4321.prices.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 *  Custom Web Security.
 */

/** The Constant log. */
@Slf4j
@Configuration
public class CustomWebSecurity extends WebSecurityConfigurerAdapter {
	
	/** The config. */
	@Autowired private com.gmail.damor4321.prices.configuration.Configuration config;

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if ("true".equalsIgnoreCase(config.getSecurityEnabled())) {
			http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
		} else {
			http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		}
	}

	/**
	 * Configure Global.
	 *
	 * @param auth auth
	 * @throws Exception exception
	 */

	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		/* Use configuration to load the ps and decrypt it, if it's encrypted */
		if (config.getSecurityEnabled().equalsIgnoreCase("true")) {
			String encoded = new BCryptPasswordEncoder().encode(config.getServicePassword());
			auth.inMemoryAuthentication()
			.withUser(config.getServiceName())
			.password(encoded)
			.roles("USER");
			log.info("Started web security with service name " + config.getServiceName());
		} else {
			log.info("started web security without security");
		}
	}
	
	/**
	 * ps Encoder.
	 *
	 * @return os encoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}