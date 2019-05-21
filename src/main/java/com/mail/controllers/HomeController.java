package com.mail.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mail.dto.ShowBooksDto;
import com.mail.services.HomePageService;
import com.mail.services.SearchBarService;
import com.mail.services.ShowBooksService;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private ShowBooksService showBooksService;
	@Autowired
	private HomePageService homePageService;
	@Autowired
	private SearchBarService searchBarService;

	@GetMapping("/home.htm")
	public void showHome(ModelMap modelMap, @RequestParam(name = "query", required = false) String query) {

		if (logger.isDebugEnabled())
			logger.debug("Enter into customer home controller method");

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!username.equals("anonymousUser")) {
			String customerFirstName = homePageService.getCustomerFirstName(username);
			customerFirstName = customerFirstName.replace(customerFirstName.charAt(0),
					Character.toUpperCase(customerFirstName.charAt(0)));

			modelMap.addAttribute("user", "Hi, " + customerFirstName);
		}
		if (query != null && query.length() != 0) {
			ArrayList<ShowBooksDto> booksDtos = searchBarService.getBooksFromQuery(query);
			if (booksDtos.isEmpty())
				modelMap.addAttribute("empty", "There are no matching books available");
				modelMap.addAttribute("books", booksDtos);
		} else
			modelMap.addAttribute("books", showBooksService.showBooks());
		if (logger.isDebugEnabled())
			logger.debug("Exit from customer home controller method");

	}

	@GetMapping("/admin-home.htm")
	public String showAdminHome() {
		return "admin-home";
	}
}