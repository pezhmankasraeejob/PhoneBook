/**
 * 
 */
package com.pezhmankasraee.phonebook.person;

/**
 * @author pezhman kasraee
 *
 */
public interface Personage {
	
	boolean validateFullNameLength(String fullname);
	boolean validateMobileLength(String mobile);
	boolean validatePhoneLength(String phone);
	boolean validateEmailLength(String email);
	boolean validateEmailStructure(String email);
	boolean validateAddressLength(String address);
	boolean validateCountryLength(String country);
	boolean validateNotesLength(String notes);
	
}
