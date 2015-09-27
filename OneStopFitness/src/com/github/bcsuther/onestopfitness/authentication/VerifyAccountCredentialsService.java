package com.github.bcsuther.onestopfitness.authentication;

import org.springframework.security.core.userdetails.UserDetails;

import com.github.bcsuther.onestopfitness.model.UserProfile;

public interface VerifyAccountCredentialsService {
	public boolean performVerification(UserDetails userDetails, UserProfile userProfile);
}
