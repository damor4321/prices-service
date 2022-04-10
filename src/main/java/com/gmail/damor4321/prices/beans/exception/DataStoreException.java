package com.gmail.damor4321.prices.beans.exception;

// TODO: Auto-generated Javadoc
/**
 *  NoPriceFoundException.
 */
public class DataStoreException extends PricesServiceException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 *  NoPriceFoundException.
	 */
	public DataStoreException() {
		super();
	}

	/**
	 * NoPriceFoundException.
	 *
	 * @param e the e
	 */
	public DataStoreException(Exception e) {
		super(e);
	}

	/**
	 * NoPriceFoundException.
	 *
	 * @param msg the msg
	 */
	public DataStoreException(String msg) {
		super(new Exception(msg));
	}
}