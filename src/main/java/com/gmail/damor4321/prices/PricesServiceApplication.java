package com.gmail.damor4321.prices;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gmail.damor4321.prices.configuration.Configuration;

// TODO: Auto-generated Javadoc
/**
 *  Main and class.
 */
@SpringBootApplication
@ComponentScan(
	basePackages = "com.gmail.damor4321.*"
)


@EntityScan("com.gmail.damor4321.*")
@EnableJpaRepositories("com.gmail.damor4321.*")
public class PricesServiceApplication {

	
	/**  Variables *. */
	@Autowired private Configuration configuration;
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
	
		SpringApplication.run(PricesServiceApplication.class, args);
	
	}
	
	/**
	 * Get new datasource.
	 *
	 * @return datasource db
	 */
	
	@Bean
	@Primary
	public DataSource dataSource() {
	
		return DataSourceBuilder.create()
			.username (configuration.getUsername())
			.password(configuration.getPassword())
			.url(configuration.getUrl())	
			.build();
	}

}
