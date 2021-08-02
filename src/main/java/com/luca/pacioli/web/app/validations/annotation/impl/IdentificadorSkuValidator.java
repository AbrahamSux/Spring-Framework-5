package com.luca.pacioli.web.app.validations.annotation.impl;

import com.luca.pacioli.web.app.validations.annotation.IdentificadorSku;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorSkuValidator implements ConstraintValidator<IdentificadorSku, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if ( value.matches("[0-9]{3}[-][\\d]{3}[-][\\d]{3}[-][A-Z]{2}") ) {
            return true;
        }
        return false;
    }

}
