/**
 * 
 */
package com.pezhmankasraee.phonebook.pbexception;

/**
 * @author pezhman
 *
 */
public class MobileLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1517572531419917778L;

	
	@Override
	public String getMessage() {
		return "The length of mobile cannot be longer than 20 characters";
	}
}
