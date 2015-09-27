package com.github.bcsuther.onestopfitness.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.github.bcsuther.onestopfitness.authentication.VerifyAccountCredentialsService;
import com.github.bcsuther.onestopfitness.model.UserProfile;
import com.github.bcsuther.onestopfitness.security.PasswordEncryptorService;

@Component
@Qualifier("verifyAccountCredentialsService")
public class VerifyAccountCredentialsServiceImpl implements VerifyAccountCredentialsService {

	@Autowired
	@Qualifier("passwordEncryptorService")
	PasswordEncryptorService passwordEncryptorService;
	
	@Override
	public boolean performVerification(UserDetails userDetails, UserProfile userProfile) {
		if(userDetails.getUsername().equalsIgnoreCase(userProfile.getUsername()) 
				&& this.passwordEncryptorService.passwordMatches(userProfile.getPassword(), userDetails.getPassword())) {
			return true;
		}
		return false;
	}

}
