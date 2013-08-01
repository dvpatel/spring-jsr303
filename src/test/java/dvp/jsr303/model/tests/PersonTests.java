package dvp.jsr303.model.tests;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import dvp.jsr303.model.Address;
import dvp.jsr303.model.Person;

/**
 * Sample unit tests for Person model object and properties.  Include additional unit tests as you see fit.
 * @author Dipesh Patel
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/RequestDispatcher-junit-test.xml")
public class PersonTests {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/*
	 * Spring wired validator (JSR-303, Hibernate implementation)
	 */
    @Autowired
    private Validator validator;
	
	@Test()
	public void testValidPersonObject() {
	
		Person person = new Person() ;
		person.setFirstname("John") ;
		person.setLastname("Smith") ;
		person.setAge(18) ;
		person.setEmail("test@yahoo.com") ;
		person.setPhone("(384)847-2939") ;
		
		Address address = new Address() ;
		address.setStreet("100 Paseo Padrea Pkwy.") ;
		address.setCity("Fremont") ;
		address.setState("CA") ;
		address.setZipcode("94555") ;
		address.setCountry("USA") ;
		
		person.setAddress(address) ;
		
		// validate the input
		Set<ConstraintViolation<Person>> violations = validator.validate(person);
		PrintUtility.printMessage(log, violations);
				
		assertEquals(violations.size(), 0);		
	}

	@Test()
	public void testInvalidPersonObject() {
	
		Person person = new Person() ;
		person.setFirstname("<script>alert('XSS')</script>") ;
		person.setLastname(">>''>>") ;
		person.setAge(999) ;
		person.setEmail("test@asdofj.cojaiojdsfijasidfjaosidjf") ;
		person.setPhone("98475837458739847593745983457") ;		
		person.setAddress(null) ;
		
		// validate the input
		Set<ConstraintViolation<Person>> violations = validator.validate(person);
		PrintUtility.printMessage(log, violations);
				
		//  Expecting 6 failures ;
		assertEquals(violations.size(), 6);		
	}		

	@Test()
	public void testPersonObjectWithBadAddress() {
	
		Person person = new Person() ;
		person.setFirstname("John") ;
		person.setLastname("Smith") ;
		person.setAge(21) ;
		person.setEmail("test@yahoo.com") ;
		person.setPhone("(384)847-2939") ;
		
		Address address = new Address() ;
		address.setStreet("<script>alert('XSS')</script>") ;
		address.setCity("<M*DF*(SDF*(F") ;
		address.setState("ABC123") ;
		address.setZipcode("ACD##DD") ;
		address.setCountry("X3d23ddd") ;
		
		person.setAddress(address) ;
		
		// validate the input
		Set<ConstraintViolation<Person>> violations = validator.validate(person);
		PrintUtility.printMessage(log, violations);
				
		//  Expecting 6 failures ;
		assertEquals(violations.size(), 5);		
	}		

}