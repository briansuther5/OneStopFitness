package com.github.bcsuther.onestopfitness.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.github.bcsuther.onestopfitness.dao.AccountDao;
import com.github.bcsuther.onestopfitness.model.UserProfile;

@Component
@Qualifier("accountValidator")
public class AccountValidator implements Validator {

	@Autowired
	@Qualifier("accountDao")
	AccountDao accountDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserProfile.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Username is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
		
		UserProfile userProfile = (UserProfile) target;
		UserProfile existingUser = accountDao.findUserByUsername(userProfile.getUsername());
		if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()) {
			errors.rejectValue("username", "error.username", "Username already exist. Please choose a different one.");
		}
		
	}
}
