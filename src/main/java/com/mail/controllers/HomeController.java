package com.mail.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home.htm")
	public void showHome(ModelMap map) {

		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		map.addAttribute("user", user);

	}

	@GetMapping("/admin-home.htm")
	public String showAdminHome() {
		
		return "admin-home";
	}
}
