package dvp.jsr303.constraints;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * 
 * Example of custom constraint using US_Phone RegEx from OWASP
 * @author Dipesh Patel
 *
 */

@NotNull()
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=PhoneValidator.class) 
public @interface Phone {
	
   String message() default "Phone number validation failed.";
   Class[] groups() default {};
   Class<? extends Payload>[] payload() default {};
   
}