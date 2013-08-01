package dvp.jsr303.constraints;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * jsr-303 Phone validator
 * @author Dipesh Patel
 *
 */

public class PhoneValidator implements ConstraintValidator<Phone, String>
{
	protected final Log logger = LogFactory.getLog(getClass());
	
	private Phone phone ;
	
	//  From owasp:  US phone number with or without dashes
	private String expression = "^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$";
		
	private Pattern p = Pattern.compile(expression);
	
    @Override
    public void initialize(Phone constraint) { 
    	
    	this.phone = constraint ;
    	    	
    }
 
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		try {
		
			boolean result = (value != null) && this.p.matcher(value).matches() ;			
			if (!result) {
				
				this.logger.error("Failed validation for phone number:  " + value) ;
							
			}
			
			return result ;
						
		} catch (Exception e) {
			
			this.logger.error("Error validating phone number:  " + e.getMessage()) ;
			return false ;
			
		} 
		
	}
}