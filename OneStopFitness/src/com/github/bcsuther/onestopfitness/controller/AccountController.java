package com.github.bcsuther.onestopfitness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createAccount(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "createAccount";
	}
}
