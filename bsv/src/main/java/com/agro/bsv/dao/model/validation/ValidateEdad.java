package com.agro.bsv.dao.model.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidateEdadValidator.class)
public @interface ValidateEdad {

    String message() default "Debe ser mayor a {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
   
	int value();
}
