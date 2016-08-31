/**
 * 
 */
package com.pezhmankasraee.phonebook.pbexception;

/**
 * @author pezhman
 *
 */
public class CountryLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5137822145787019973L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The length of country cannot be longer than 50 characters";
	}

	
}
