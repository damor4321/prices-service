package com.gmail.damor4321.prices.beans.database;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class PriceDb.
 */
@Table(name = "prices", schema = "pos")
/*
 Note: last_update and last_update_by fiels are not mapped to this entity 
 because they are not included for the service requirements
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
@Entity

/**
 * Instantiates a new price db.
 */
@NoArgsConstructor

/**
 * Instantiates a new price db.
 *
 * @param id the id
 * @param brandId the brand id
 * @param startDate the start date
 * @param endDate the end date
 * @param priceList the price list
 * @param productId the product id
 * @param priorityId the priority id
 * @param price the price
 * @param currency the currency
 */
@AllArgsConstructor
public class PriceDb {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The brand id. */
	@Column(name = "brand_id")
	private Integer brandId;

	/** The start date. */
	@Column(name = "start_date")
	private LocalDateTime startDate;

	/** The end date. */
	@Column (name = "end_date")
	private LocalDateTime endDate;

	/** The price list. */
	@Column(name = "price_list_id")
	private Integer priceList;
	
	/** The product id. */
	@Column (name = "product_id")
	private Long productId;

	/** The priority id. */
	@Column(name = "priority_id")
	private Integer priorityId;
	
	/** The price. */
	@Column(name = "price")
	private BigDecimal price;

	/** The currency. */
	@Column(name = "currency")
	private String currency;
}
