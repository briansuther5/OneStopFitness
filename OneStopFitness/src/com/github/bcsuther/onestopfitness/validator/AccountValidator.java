package com.github.bcsuther.onestopfitness.validator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.github.bcsuther.onestopfitness.model.UserProfile;

@Component
@Qualifier("accountValidator")
public class AccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserProfile.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.firstName", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.firstName", "username is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.firstName", "Email is required.");
	}
}
