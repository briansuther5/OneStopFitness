package com.github.bcsuther.onestopfitness.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class WebUserProfile extends User {

	private UserProfile userProfile;
	
	public WebUserProfile(String username
			, String password
			, boolean enabled
			, boolean accountNonExpired
			, boolean credentialsNonExpired
			, boolean accountNonLocked
			, Collection<? extends GrantedAuthority> authorities
			, UserProfile userProfile) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userProfile = userProfile;
	}

	private static final long serialVersionUID = -395680980538446679L;

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
}
