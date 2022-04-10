package com.gmail.damor4321.prices.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.damor4321.prices.beans.object.Price;
import com.gmail.damor4321.prices.services.PricesService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 *  Prices controller.
 */
@CrossOrigin(origins = "*")
@RequestMapping(path = "/prices/v1")
@RestController

/** The Constant log. */
@Slf4j
public class PricesController {

	/** The service. */
	@Autowired private PricesService service;
	
	/**
	 * Returns the price for a product.
	 *
	 * @param productId the product id
	 * @param brandId the brand id
	 * @param requestDate the request date
	 * @return a Response Entity containing the list of cloud providers
	 */
	@RequestMapping(value="/product" , method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Price> getPriceForProduct(
			@RequestParam(name = "product_id", required = true) Long productId,
			@RequestParam(name = "brand_id", required = true) Integer brandId,
			@RequestParam(value="request_date", required = true)
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime requestDate
			) 
	{

		log.info("getPriceFor Product, product_id: {}, brand_id: {}, requestDate: {}",
				productId, brandId, requestDate);
		
		Price priceResponse = service.getPriceForProduct(productId, brandId, requestDate);

		return new ResponseEntity<>(priceResponse, HttpStatus.OK);
	}
}
