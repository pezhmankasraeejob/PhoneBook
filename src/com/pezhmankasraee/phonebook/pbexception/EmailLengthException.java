/**
 * 
 */
package com.pezhmankasraee.phonebook.pbexception;

/**
 * @author pezhman
 *
 */
public class EmailLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4424498278840650721L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The length of email cannot be longer than 256 characters";
	}

	
}
