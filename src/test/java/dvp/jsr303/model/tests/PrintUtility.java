/**
 * 
 */
package dvp.jsr303.model.tests;

import java.util.Set;
import org.apache.commons.logging.Log;

import dvp.jsr303.model.Person;

import javax.validation.ConstraintViolation;



/**
 * Simple print utility to output junit  results for failed cases.
 * @author Dipesh Patel
 *
 */
public class PrintUtility {
	
    /*
     * Utility method to print out validation errors ;
     */
	public static void printMessage(Log log, Set<?> violations) {						
		for (Object o : violations) {
			ConstraintViolation<?> p = (ConstraintViolation<?>) o ;
			log.info("Forced violation ("+ violations.size() + "):  "  + p.getPropertyPath().toString() + " -- " + p.getMessage() + "  ("+ p.getInvalidValue() +")") ;			
		}		
	}

}
