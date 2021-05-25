package com.luca.pacioli.web.app.validations;

import com.luca.pacioli.web.app.models.entity.Usuario;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("userValidator")
public class UserValidator implements Validator {

    private static final Log LOGGER = LogFactory.getLog(UserValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">>> validate( " + target.toString() + ", " + errors.getFieldErrors() + " )");
        }

        /*if ( !((Usuario) target).getIdentificador().matches("[0-9]{3}[-][\\d]{3}[-][\\d]{3}[-][A-Z]{2}") ) {
            errors.rejectValue("identificador", "pattern.usuario.identificador");
        }*/

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "notEmpty.usuario.nombre");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "notEmpty.usuario.apellido");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "notBlank.usuario.username");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notBlank.usuario.password");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "notBlank.usuario.email");

    }

}
