package com.github.bcsuther.onestopfitness.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.SecurityContextRepository;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	@Autowired
	@Qualifier("customUserDetailsService")
	CustomUserDetailsService customUserDetailsService;
     
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
     
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }
    
    @Bean
    public SecurityContextPersistenceFilter securityContextPersistenceFilter() {
    	return new SecurityContextPersistenceFilter();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/admin/**","/newuser").access("hasRole('ADMIN')")
        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
        .and().formLogin().loginPage("/login")
        .usernameParameter("ssoId").passwordParameter("password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}