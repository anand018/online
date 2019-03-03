package com.mail.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.mail.dto.ShowBooksDto;
import com.mail.services.ShowBooksService;

@Controller
public class ShowBooksController {

	@Autowired
	private ShowBooksService serviceImpl;

	@GetMapping("show-books.htm")
	public void showBooks(ModelMap modelMap) {

		List<ShowBooksDto> books = serviceImpl.showBooks();

		modelMap.addAttribute("books", books);
	}
}
