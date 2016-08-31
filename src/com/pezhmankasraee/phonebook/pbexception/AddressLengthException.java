package com.pezhmankasraee.phonebook.pbexception;

public class AddressLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1344022687026032691L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The length of Address cannot be longer than 500 characters";
	}

	
}
