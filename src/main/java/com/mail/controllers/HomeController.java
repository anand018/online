package com.mail.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@GetMapping("/home.htm")
	public void showHome(ModelMap map) {

		if (logger.isDebugEnabled())
			logger.debug("Enter into customer home controller method");

		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		map.addAttribute("user", "welcome " + user);
		if (logger.isDebugEnabled())
			logger.debug("Exit from customer home controller method");

	}

	@GetMapping("/admin-home.htm")
	public String showAdminHome() {
		return "admin-home";
	}
}