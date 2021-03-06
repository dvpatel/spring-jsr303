package dvp.jsr303.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

/**
 * Sample object representing a person's address.
 * Some regexp patterns are referenced from OWASP documentation.
 * @author Dipesh Patel
 *
 */
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp="^[a-zA-Z0-9 .-]{3,100}$", message="Invalid street format.")
	public String street ;
	
	@Pattern(regexp="^[a-zA-Z0-9 -]{2,100}$", message="Enter proper city.")	
	public String city;
	
	@Pattern(regexp="^(AE|AL|AK|AP|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MP|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY)$", message="No such state acronym.")
	public String state;

	@Pattern(regexp="^\\d{5}(-\\d{4})?$", message="Invalid zip code.")
	public String zipcode ;
	
	@Pattern(regexp="^(US|USA|United States|United States Of America)$", message="Please enter US or USA")
	public String country ;	
	
	/**
	 * Return person's street address.
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}	
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
		
	/**
	 * @return the state acronym
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}	
	
	/**
	 * @return the zip
	 */
	public String getZipcode() {
		return zipcode ;
	}
	
	/**
	 * @param zip the zip to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}	
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}	
}