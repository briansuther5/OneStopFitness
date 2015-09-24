package com.github.bcsuther.onestopfitness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/summary")
public class SummaryController {

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view( //
			@RequestParam(value = "accountCreated", required=false) final boolean accountCreated //
			, HttpServletRequest request //
			, HttpServletResponse response //
			, Model model) {
		model.addAttribute("accountCreated", accountCreated);
		return "summary";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact( //
			HttpServletRequest request //
			, HttpServletResponse response //
			, Model model) {
		return "contact";
	}
}
