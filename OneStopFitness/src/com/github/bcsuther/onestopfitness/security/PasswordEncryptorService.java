package com.github.bcsuther.onestopfitness.security;

public interface PasswordEncryptorService {
	public String encryptPassword(String password);
	public boolean passwordMatches(String rawPassword, String encodedPassword);
}
