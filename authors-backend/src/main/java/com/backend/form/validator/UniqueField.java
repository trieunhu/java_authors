package com.backend.form.validator;

import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueFieldValidator.class)
@Documented
public @interface UniqueField
{
    String message() default "{0} đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    String fieldName();
    
}