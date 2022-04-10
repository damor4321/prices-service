package com.gmail.damor4321.prices.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gmail.damor4321.prices.beans.exception.NoPriceFoundException;

/**
 * The Class PricesServiceExceptionController.
 * 
 * explanation: https://www.baeldung.com/exception-handling-for-rest-with-spring#controlleradvice
 */
@RestControllerAdvice
public class PricesServiceExceptionController {

	/**
	 * Handles NoPriceFoundException.
	 *
	 * @param e the e
	 * @return ResponseEntity
	 */
	@ExceptionHandler(NoPriceFoundException.class)
	public ResponseEntity<Object> handleNoPriceFoundException(NoPriceFoundException e) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("ErrorMessage", e.getMessage());
		body.put("Exception", "NoPriceFoundException");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * Bellow this you can handle another possible PricesServicesException child exceptions
	 * in the same way NoPriceFoundException is handled
	 * in order to provide error responses for the user requests  
	 */


}
