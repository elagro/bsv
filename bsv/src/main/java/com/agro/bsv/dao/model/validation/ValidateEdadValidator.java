package com.agro.bsv.dao.model.validation;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateEdadValidator implements ConstraintValidator<ValidateEdad, LocalDate> {

	private int value;
	
	
    public void initialize(ValidateEdad constraint) {
        value = constraint.value();
    }
    
    
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		
		try {
			LocalDate curDate = LocalDate.now();  
			
			  
			if ((value != null) && (curDate != null))   
			{  
				if (Period.between(value, curDate).getYears() < this.value) {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}