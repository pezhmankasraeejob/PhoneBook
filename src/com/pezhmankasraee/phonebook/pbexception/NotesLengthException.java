/**
 * 
 */
package com.pezhmankasraee.phonebook.pbexception;

/**
 * @author pezhman
 *
 */
public class NotesLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152380255006525205L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The length of notes cannot be longer than 1000 characters";
	}

	
}
