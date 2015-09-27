package com.github.bcsuther.onestopfitness.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Qualifier("passwordEncryptorService")
public class PasswordEncryptorServiceImpl implements PasswordEncryptorService {

	@Autowired
	@Qualifier("passwordEncoder")
	PasswordEncoder passwordEncoder;
	
	@Override
	public String encryptPassword(String password) {
		return this.passwordEncoder.encode(password);
	}

	@Override
	public boolean passwordMatches(String rawPassword, String encodedPassword) {
		return this.passwordEncoder.matches(rawPassword, encodedPassword);
	}

}
