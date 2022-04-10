package com.gmail.damor4321.prices.beans.exception;

// TODO: Auto-generated Javadoc
/**
 *  NoPriceFoundException.
 */
public class NoPriceFoundException extends PricesServiceException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 *  NoPriceFoundException.
	 */
	public NoPriceFoundException() {
		super();
	}

	/**
	 * NoPriceFoundException.
	 *
	 * @param e the e
	 */
	public NoPriceFoundException(Exception e) {
		super(e);
	}

	/**
	 * NoPriceFoundException.
	 *
	 * @param msg the msg
	 */
	public NoPriceFoundException(String msg) {
		super(new Exception(msg));
	}
}