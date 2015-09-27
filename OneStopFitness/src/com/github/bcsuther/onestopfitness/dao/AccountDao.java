package com.github.bcsuther.onestopfitness.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.github.bcsuther.onestopfitness.model.UserProfile;

public interface AccountDao {
	public void createUserAccount(UserProfile userProfile);
	public UserProfile findUserByUsername(String username);
	public UserProfile findUserByUserDetails(UserDetails userDetails);
}
