package dvp.jsr303.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dvp.jsr303.model.Address;
import dvp.jsr303.model.Person;

/**
 * 
 * Sample controller for processing input for Person and Address objects
 * Note that sample is using velocity template engine for UI rendering.  
 *
 * @author Dipesh Patel
 *
 */

@Controller
@SessionAttributes("person")
@RequestMapping("/")
public class RegistrationController {

	protected final Log log = LogFactory.getLog(getClass());	
	
	/*
	 * Create Person object
	 */
	private Person getPerson() {		
		Person person = new Person() ;
		Address address = new Address() ;
		person.setAddress(address) ;
		return person ;		
	}
	
	/*
	 * Present input form with Person object form binding
	 */
	@RequestMapping()
	public String presentRegistrationForm(ModelMap model) {
		
		model.addAttribute("person", this.getPerson());
		return "inputForm" ;
		
	}	

	/*
	 * Input processor.  Present results page or error page which is registration page with in-line error
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistrationForm(@Valid @ModelAttribute("person") Person person, BindingResult result) {	

		/*
		 * Spring will invoke Hibernate's JSR303 validator for validating user input that maps to
		 * Person / Address objects 
		 */		
		
		if (result.hasErrors()) {

			log.error("Data validation error during form processing.");		

			/*
			 * Error handling code.
			 * For this implementation, simply reset error fields, and display in-line errors on inputForm page.
			 */					
			BeanWrapper b = new BeanWrapperImpl(person) ;			
			BeanWrapper _b = new BeanWrapperImpl(this.getPerson()) ;			
			for (FieldError fe : result.getFieldErrors()) {
				log.error("DV Error, resetting field:  " + fe.getField()) ;
				b.setPropertyValue(fe.getField(), _b.getPropertyValue(fe.getField())) ;
			}

			return "inputForm" ;
			
		}

		//  load success page.
		log.debug("JSR303 data validation success.") ; 
		
		/**** Perform your business logic processing ;  This sample has none ; ****/
		
		//  Go to success page.
		return "results" ;			
	}

	
	/*
	 * Error page template
	 */
	@RequestMapping(value = "/error")
	public String showError() throws ServletException, IOException {
		
		log.error("Invalid request.") ;
		return "error" ;
		
	}			
}