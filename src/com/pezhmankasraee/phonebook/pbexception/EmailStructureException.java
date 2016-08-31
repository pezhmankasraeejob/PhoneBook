/**
 * 
 */
package com.pezhmankasraee.phonebook.pbexception;

/**
 * @author pezhman
 *
 */
public class EmailStructureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6718205314248218797L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "An Invalid e-mail format.";
	}

	
}
