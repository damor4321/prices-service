package com.gmail.damor4321.prices.beans.object;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
@Data

/**
 * Instantiates a new price.
 */
@NoArgsConstructor

/**
 * Instantiates a new price.
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
public class Price {
	
	/** The id. */
	@JsonIgnore
	private Long id;
	
	/** The brand id. */
	private Integer brandId;

	/** The start date. */
	private LocalDateTime startDate;

	/** The end date. */
	private LocalDateTime endDate;

	/** The price list. */
	private Integer priceList;
	
	/** The product id. */
	private Long productId;

	/** The priority id. */
	@JsonIgnore
	private Integer priorityId;
	
	/** The price. */
	private BigDecimal price;

	/** The currency. */
	private String currency;
}
