package com.github.bcsuther.onestopfitness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.bcsuther.onestopfitness.service.UserService;

@Controller
@RequestMapping(value="/calendar")
public class CalendarController {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(HttpServletRequest req, HttpServletResponse resp, Model model) {
		model.addAttribute("userProfile", userService.getLoggedInUser());
		return "calendar";
	}
}
