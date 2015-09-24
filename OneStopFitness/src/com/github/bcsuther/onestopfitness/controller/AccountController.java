package com.github.bcsuther.onestopfitness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.bcsuther.onestopfitness.dao.AccountDao;
import com.github.bcsuther.onestopfitness.model.AccountType;
import com.github.bcsuther.onestopfitness.model.UserProfile;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	@Autowired
	@Qualifier("accountDao")
	AccountDao accountDao;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateAccountForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		UserProfile userProfile = new UserProfile();
		userProfile.setAccountType(AccountType.accountHolder.getAccountName());
		model.addAttribute("userProfile", userProfile);
		return "createAccount";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createUserAccount(@ModelAttribute("userProfile") final UserProfile userProfile) {
		this.accountDao.createUserAccount(userProfile);
		return "redirect:/app/summary/view";
	}
}
