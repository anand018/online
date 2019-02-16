package com.mail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.mail.services.ShowBooksServiceImpl;

@Controller
public class ShowBooksController {

	@Autowired
	private ShowBooksServiceImpl serviceImpl;

	@GetMapping("show-books.htm")
	public void showBooks(ModelMap modelMap) {
		modelMap.addAttribute("books", serviceImpl.showBooks());
		System.out.println(serviceImpl.showBooks().get(1).getCovers().toString()+"...................");
	}

}
