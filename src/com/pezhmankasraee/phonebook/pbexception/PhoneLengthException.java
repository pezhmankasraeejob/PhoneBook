/**
 * 
 */
package com.pezhmankasraee.phonebook.pbexception;

/**
 * @author pezhman
 *
 */
public class PhoneLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2995311843196207296L;

	@Override
	public String getMessage() {
		return "The length of phone cannot be longer than 20 characters";
	}
	
	

}
