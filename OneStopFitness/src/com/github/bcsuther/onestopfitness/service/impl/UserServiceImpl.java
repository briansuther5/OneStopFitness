package com.github.bcsuther.onestopfitness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.github.bcsuther.onestopfitness.dao.jdbc.AccountDaoJdbc;
import com.github.bcsuther.onestopfitness.model.UserProfile;
import com.github.bcsuther.onestopfitness.model.WebUserProfile;
import com.github.bcsuther.onestopfitness.service.UserService;

@Component
@Qualifier("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("accountDao")
	AccountDaoJdbc accountDao;
	
	@Override
	public UserProfile getLoggedInUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if(securityContext.getAuthentication() instanceof AnonymousAuthenticationToken) {
			return new UserProfile();
		} else {
			WebUserProfile webUserProfile = (WebUserProfile) securityContext.getAuthentication().getPrincipal();
			return webUserProfile.getUserProfile();
		}
	}
}
