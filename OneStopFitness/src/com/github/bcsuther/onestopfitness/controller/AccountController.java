package com.github.bcsuther.onestopfitness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.bcsuther.onestopfitness.authentication.VerifyAccountCredentialsService;
import com.github.bcsuther.onestopfitness.dao.jdbc.AccountDaoJdbc;
import com.github.bcsuther.onestopfitness.model.AccountType;
import com.github.bcsuther.onestopfitness.model.UserProfile;
import com.github.bcsuther.onestopfitness.security.CustomUserDetailsService;
import com.github.bcsuther.onestopfitness.service.UserService;
import com.github.bcsuther.onestopfitness.validator.AccountValidator;

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
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("accountValidator")
	AccountValidator accountValidator;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateAccountForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		UserProfile userProfile = new UserProfile();
		userProfile.setAccountType(AccountType.accountHolder.getAccountName());
		model.addAttribute("userProfile", userProfile);
		return "createAccount";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createUserAccount(@ModelAttribute UserProfile userProfile //
	, BindingResult result //
	, HttpServletRequest request //
	, HttpServletResponse response //
	, Model model) {
		try {
			this.accountValidator.validate(userProfile, result);
			if (result.hasErrors()) {
				model.addAttribute("userProfile", userProfile);
				return "createAccount";
			}
			this.accountDao.createUserAccount(userProfile);
			return "redirect:/app/summary/view?accountCreated=true";
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			model.addAttribute("stacktrace", e.getStackTrace());
			return "error";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userProfile") UserProfile userProfile, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttr, Model model) {
		UserDetails userDetails;
		try {
			userDetails = customUserDetailsService.loadUserByUsername(userProfile.getUsername());
		} catch(UsernameNotFoundException e) {
			return "redirect:/app/summary/view?invalidCredentials=true";
		}
		if(verifyAccountCredentialsService.performVerification(userDetails, userProfile)) {
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:/app/summary/view";
		}
		return "redirect:/app/summary/view?invalidCredentials=true";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttr, Model model) {
		SecurityContextHolder.clearContext();
		return "redirect:/app/summary/view";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String viewProfile(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttr, Model model) {
		model.addAttribute("userProfile", userService.getLoggedInUser());
		return "profile";
	}
}
