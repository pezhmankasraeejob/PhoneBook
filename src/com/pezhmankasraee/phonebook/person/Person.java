/**
 * 
 */
package com.pezhmankasraee.phonebook.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.pezhmankasraee.phonebook.pbexception.*;

/**
 * @author pezhman
 *
 */
public class Person implements Personage {

	private String fullName;
	private String mobile;
	private String phone;
	private String email;
	private String address;
	private String country;
	private String notes;

	private Person() {
		this.fullName = "None";
	}

	public Person(String fullname) {
		this();
		if (!this.validateFullNameLength(fullname))
			try {
				throw new FullNameLengthException();
			} catch (FullNameLengthException e) {
				System.out.println(e.getMessage());
			}
		else
			this.fullName = fullname;

	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		if (!this.validateMobileLength(mobile))
			try {
				throw new MobileLengthException();
			} catch (MobileLengthException e) {
				System.out.println(e.getMessage());
			}
		else
			this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		if (!this.validatePhoneLength(phone))
			try {
				throw new PhoneLengthException();
			} catch (PhoneLengthException e) {
				System.out.println(e.getMessage());
			}
		else
			this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		if (!this.validateEmailLength(email))
			try {
				throw new EmailLengthException();
			} catch (EmailLengthException e) {
				System.out.println(e.getMessage());
			}
		else if (!this.validateEmailStructure(email))
			try {
				throw new EmailStructureException();
			} catch (EmailStructureException e) {
				System.out.println(e.getMessage());
			}
		else
			this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		if (!this.validateAddressLength(address))
			try {
				throw new AddressLengthException();
			} catch (AddressLengthException e) {
				System.out.println(e.getMessage());

			}
		else
			this.address = address;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		if (!this.validateCountryLength(country))
			try {
				throw new CountryLengthException();
			} catch (CountryLengthException e) {
				System.out.println(e.getMessage());
			}
		else
			this.country = country;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		if(!this.validateNotesLength(notes))
			try {
				throw new NotesLengthException();
			} catch (NotesLengthException e) {
				System.out.println(e.getMessage());
			}
		else
			this.notes = notes;
	}

	@Override
	public boolean validateFullNameLength(String fullname) {
		if (fullname.length() > 100)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateMobileLength(String mobile) {
		if (mobile.length() > 20)
			return false;
		else
			return true;
	}

	@Override
	public boolean validatePhoneLength(String phone) {
		if (phone.length() > 20)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateEmailLength(String email) {
		if (email.length() > 256)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateEmailStructure(String email) {
		String regx = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern emailStructure = Pattern.compile(regx);
		Matcher emailInput = emailStructure.matcher(email);
		if (emailInput.find())
			return true;
		else
			return false;
	}

	@Override
	public boolean validateAddressLength(String address) {
		if (address.length() > 500)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateCountryLength(String country) {
		if (country.length() > 50)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateNotesLength(String notes) {
		if (notes.length() > 1000)
			return false;
		else
			return true;
	}

}
