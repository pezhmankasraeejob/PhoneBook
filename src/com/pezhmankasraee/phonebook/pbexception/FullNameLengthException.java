/**
 * 
 */
package com.pezhmankasraee.phonebook.pbexception;

/**
 * @author pezhman
 *
 */
public class FullNameLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4957217151129454058L;

	@Override
	public String getMessage() {
		return "The length of fullname cannot be longer than 100 characters";
	}
	
}