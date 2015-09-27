package com.github.bcsuther.onestopfitness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.bcsuther.onestopfitness.service.UserService;

@Controller
@RequestMapping(value="/summary")
public class SummaryController {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view( //
			@RequestParam(value = "accountCreated", required=false) final boolean accountCreated //
			, @RequestParam(value = "invalidCredentials", required=false) final boolean invalidCredentials //
			, HttpServletRequest request //
			, HttpServletResponse response //
			, Model model) {
		model.addAttribute("accountCreated", accountCreated);
		model.addAttribute("invalidCredentials", invalidCredentials);
		model.addAttribute("userProfile", userService.getLoggedInUser());
		return "summary";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact( //
			HttpServletRequest request //
			, HttpServletResponse response //
			, Model model) {
		model.addAttribute("userProfile", userService.getLoggedInUser());
		return "contact";
	}
}
