package com.mail.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.mail.services.HomePageService;
import com.mail.services.ShowBooksService;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private ShowBooksService serviceImpl;
	@Autowired
	private HomePageService homePageService;

	@GetMapping("/home.htm")
	public void showHome(ModelMap modelMap) {

		if (logger.isDebugEnabled())
			logger.debug("Enter into customer home controller method");

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		if (!username.equals("anonymousUser")) {
			String customerFirstName = homePageService.getCustomerFirstName(username);
			modelMap.addAttribute("user", "Hi, " + customerFirstName);
		}
		modelMap.addAttribute("books", serviceImpl.showBooks());

		if (logger.isDebugEnabled())
			logger.debug("Exit from customer home controller method");

	}

	@GetMapping("/admin-home.htm")
	public String showAdminHome() {
		return "admin-home";
	}
}