package patel.dipesh.jsr303.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 
 * Sample model class representing a "Person"
 * Some regexp patterns are referenced from OWASP documentation.
 * @author Dipesh Patel
 *
 */
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Pattern(regexp="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*){1,100}$")
	private String firstName ;
	
	@Pattern(regexp="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*){1,100}$")	
	private String lastName ;	

	@Pattern(regexp="^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$")
	private String eMail ;
	
	@Min(18)
	@Max(100)
	private Integer age ;
	
	@Pattern(regexp="^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$")
	private String phone ;
	
	@NotNull()
	@Valid()
	private Address address ;
	
	/*
	 * Setter for Person's first name.
	 * @param inp first name.
	 */
	public void setFirstName(String inp) {		
		this.firstName = inp ;		
	}
	
	/*
	 * Getter for Person's first name.
	 * @return person's first name
	 */	
	public String getFirstName() {
		return this.firstName ;		
	}
		
	/*
	 * Setter for Person's last name.
	 * @param inp last name.
	 */
	public void setLastName(String inp) {		
		this.firstName = inp ;		
	}
	
	/*
	 * Getter for Person's last name.
	 * @return person's last name
	 */	
	public String getLastName() {
		return this.lastName ;		
	}
	
	/*
	 * Setter for Person's email address.
	 * @param inp email address. 
	 */
	public void setEmail(String inp) {		
		this.eMail = inp ;		
	}
	
	/*
	 * Getter for Person's email address.
	 * @return person's email address
	 */		
	public String getEmail() {
		return this.eMail ;		
	}

	/*
	 * Setter for Person's age.
	 * @param inp age. 
	 */
	public void setAge(Integer inp) {		
		this.age = inp ;		
	}

	/*
	 * Getter for Person's age.
	 * @return person's age 
	 */	
	public Integer getAge() {
		return this.age ;		
	}

	/*
	 * Setter for Person's phone number, US only.
	 * @param inp phone number (US only). 
	 */
	public void setPhone(String inp) {		
		this.phone = inp ;		
	}
	
	/*
	 * Getter for Person's phone number, US format.
	 * @return person's phone number
	 */		
	public String getPhone() {
		return this.phone ;		
	}

	/*
	 * Setter for Person's Address.
	 * @param inp Address object. 
	 */
	public void setAddress(Address inp) {		
		this.address = inp ;		
	}
	
	/*
	 * Getter for Person's Address.
	 * @return person's Address
	 */		
	public Address getAddress() {
		return this.address ;		
	}
}