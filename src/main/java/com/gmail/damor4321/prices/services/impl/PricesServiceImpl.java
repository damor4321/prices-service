package com.gmail.damor4321.prices.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.damor4321.prices.beans.database.PriceDb;
import com.gmail.damor4321.prices.beans.exception.NoPriceFoundException;
import com.gmail.damor4321.prices.beans.exception.PricesServiceException;
import com.gmail.damor4321.prices.beans.object.Price;
import com.gmail.damor4321.prices.repositories.PricesRepository;
import com.gmail.damor4321.prices.services.PricesService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 *  PricesService Implementation.
 */

@Service

/** The Constant log. */
@Slf4j
public class PricesServiceImpl implements PricesService {

	/** The prices repo. */
	private @Autowired PricesRepository pricesRepo;
	

	/**
	 * Method to get the price for the product at the time of the request.
	 *
	 * @param productId the product id
	 * @param brandId the brand id
	 * @param requestDate the request date
	 * @return price. the price object for the product
	 * @throws PricesServiceException the prices service exception
	 */
	@Override
	public Price getPriceForProduct(Long productId, Integer brandId, LocalDateTime requestDate)
			throws PricesServiceException {
		
		PriceDb priceDb = pricesRepo.getPricesForProductAndBrand(productId, brandId, requestDate);
				
		if(priceDb == null) {
			String errorMsg =  "Price not found for product: " + productId + ", brand_id: " + brandId;
			log.error(errorMsg);
			throw new NoPriceFoundException(errorMsg);
		}
		
		Price price = new Price();
		
		BeanUtils.copyProperties(priceDb, price);
		
		return price;
	}

}
