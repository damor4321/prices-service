package com.gmail.damor4321.prices.beans.exception;

// TODO: Auto-generated Javadoc
/**
 * This is the main exception from which all the others depend on. 
 * There are two constructors that can be used directly
 * with and without an error message.
 */
public class PricesServiceException extends Exception {


	/**
	 * Instantiates a new prices service exception.
	 */
	PricesServiceException() {
		super();
	}

	/**
	 * Instantiates a new prices service exception.
	 *
	 * @param msg the msg
	 */
	PricesServiceException(String msg) {
		super(msg);

	}


	/**
	 * Instantiates a new prices service exception.
	 *
	 * @param e the e
	 */
	PricesServiceException(Exception e) {
		super(e);

	}
}
