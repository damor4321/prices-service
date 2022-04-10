package com.gmail.damor4321.prices.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.damor4321.prices.beans.database.PriceDb;
import com.gmail.damor4321.prices.beans.exception.NoPriceFoundException;
import com.gmail.damor4321.prices.beans.object.Price;
import com.gmail.damor4321.prices.repositories.PricesRepository;
import com.gmail.damor4321.prices.services.PricesService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * PricesService Implementation.
 */
@Service



/** The Constant log. */
@Slf4j
public class PricesServiceImpl implements PricesService {

	/** The prices repository. */
	private @Autowired PricesRepository pricesRepo;


	/**
	 * Gets the price for product.
	 *
	 * @param productId the product id
	 * @param brandId the brand id
	 * @param requestDate the request date
	 * @return the price for product
	 */
	@Override
	public Price getPriceForProduct(Long productId, Integer brandId, LocalDateTime requestDate) {

		PriceDb priceDb = pricesRepo.getPricesForProductAndBrand(productId, brandId, requestDate);

		/* 
		 * if no price found we throw NoPriceFoundException, an unchecked exception to be handled by
		 * PricesServiceExceptionController inside the REST layer
		 */
		
		if (priceDb == null) {
			String errorMsg = "Price not found for product: " + productId + ", brand_id: " + brandId;
			log.warn(errorMsg);			  
			throw new NoPriceFoundException(errorMsg);
		}

		Price price = new Price();

		BeanUtils.copyProperties(priceDb, price);

		return price;
	}

}
