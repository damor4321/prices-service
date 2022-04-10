package com.gmail.damor4321.prices.services;

import java.time.LocalDateTime;

import com.gmail.damor4321.prices.beans.exception.PricesServiceException;
import com.gmail.damor4321.prices.beans.object.Price;

// TODO: Auto-generated Javadoc
/**
 *  Interface to manage the prices.
 */
public interface PricesService {

	/**
	 * Method to get the price for the product at the time of the request.
	 *
	 * @param productId the product id
	 * @param brandId the brand id
	 * @param requestDate the request date
	 * @return Price. Response bean with the price data for the product
	 * @throws PricesServiceException the prices service exception
	 */

	public Price getPriceForProduct(Long productId, Integer brandId, LocalDateTime requestDate)
			throws PricesServiceException;

}

