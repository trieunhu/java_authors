package com.backend.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.backend.controllers.UserController;
import com.backend.model.User;
import com.backend.service.UserService;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserService userService;
	
	private String fieldName;
	private String message;

    @Override
    public void initialize(final UniqueField constraintAnnotation) {
    		fieldName = constraintAnnotation.fieldName();
    		message = constraintAnnotation.message();
    		logger.info("khoi tao:"+fieldName);
    }

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		logger.info("co vao ham valide:"+arg0);
		User u = null;
		if(fieldName.equals("email")) {
			u = userService.findByEmail(arg0);
		}
		if(fieldName.equals("username")) {
			u = userService.findByUsername(arg0);
		}
		if(u != null) {
			arg1.buildConstraintViolationWithTemplate(String.format(message, messageSource.getMessage(fieldName, null, LocaleContextHolder.getLocale())));
			return false;
		}
		return true;
	}
}