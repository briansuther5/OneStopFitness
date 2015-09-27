package com.github.bcsuther.onestopfitness.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.github.bcsuther.onestopfitness.dao.AccountDao;
import com.github.bcsuther.onestopfitness.model.UserProfile;
import com.github.bcsuther.onestopfitness.model.WebUserProfile;

@Component
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	@Qualifier("accountDao")
	AccountDao accountDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserProfile userProfile = accountDao.findUserByUsername(username);
		if(userProfile == null) {
			throw new UsernameNotFoundException(username);
		}
		try {
			return new WebUserProfile(userProfile.getUsername(), userProfile.getPassword(), true, true, true, true, new ArrayList<GrantedAuthority>(), userProfile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
