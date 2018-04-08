package com.backend.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.backend.common.Utils;
import com.backend.model.User;
import com.backend.service.UserService;

public class OldPasswordCompareValidator implements ConstraintValidator<OldPasswordCompare, String> {
	@Autowired
	private UserService userService;
	@Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void initialize(final OldPasswordCompare constraintAnnotation) {
    }

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		String username = Utils.getUserLogined();
		User u = userService.findByUsername(username);
		if(u != null) {
			if(passwordEncoder.matches(	arg0	, u.getPassword())) {
				return true;
			}
		}
		return false;
	}
}