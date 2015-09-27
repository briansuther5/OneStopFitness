package com.github.bcsuther.onestopfitness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.bcsuther.onestopfitness.authentication.VerifyAccountCredentialsService;
import com.github.bcsuther.onestopfitness.dao.jdbc.AccountDaoJdbc;
import com.github.bcsuther.onestopfitness.model.AccountType;
import com.github.bcsuther.onestopfitness.model.UserProfile;
import com.github.bcsuther.onestopfitness.security.CustomUserDetailsService;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	@Autowired
	@Qualifier("accountDao")
	AccountDaoJdbc accountDao;
	
	@Autowired
	@Qualifier("customUserDetailsService")
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	@Qualifier("verifyAccountCredentialsService")
	VerifyAccountCredentialsService verifyAccountCredentialsService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateAccountForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		UserProfile userProfile = new UserProfile();
		userProfile.setAccountType(AccountType.accountHolder.getAccountName());
		model.addAttribute("userProfile", userProfile);
		return "createAccount";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createUserAccount(@ModelAttribute("userProfile") final UserProfile userProfile, HttpServletRequest request, HttpServletResponse response) {
		this.accountDao.createUserAccount(userProfile);
		return "redirect:/app/summary/view?accountCreated=true";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userProfile") UserProfile userProfile, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttr, Model model) {
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(userProfile.getUsername());
		if(verifyAccountCredentialsService.performVerification(userDetails, userProfile)) {
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:/app/summary/view";
		}
		return "redirect:/app/summary/view?invalidCredentials=true";
	}
}
