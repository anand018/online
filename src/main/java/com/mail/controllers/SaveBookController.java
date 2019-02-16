package com.mail.controllers;

import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.mail.dto.AddBookDto;
import com.mail.form.BookForm;
import com.mail.services.AddBookServiceImpl;

@Controller
public class SaveBookController {

	@Autowired
	AddBookServiceImpl bookService;

	private static final Logger logger = Logger.getLogger(SaveBookController.class);

	@GetMapping("save-book.htm")
	public void showSaveBook(ModelMap map) {		
		
		logger.debug("showSaveBook method executed");
		BookForm bookForm = new BookForm();
		map.addAttribute("bookForm", bookForm);

	}

	@PostMapping("save-book.htm")
	public String saveBook(@RequestParam("originalBook") CommonsMultipartFile originalBook,
			@RequestParam("coverPage") CommonsMultipartFile coverPage,
			@ModelAttribute("bookForm") @Valid BookForm bookForm, BindingResult errors) {

		AddBookDto bookDto;
		boolean flag;

		if (errors.hasErrors())
			return "save-book";

		bookDto = new AddBookDto();

		bookDto.setAuthor(bookForm.getAuthor());
		bookDto.setCategory(bookForm.getCategory());
		bookDto.setCoverPage(coverPage.getBytes());
		bookDto.setEdition(bookForm.getEdition());
		bookDto.setIsbn(bookForm.getIsbn());
		bookDto.setOriginalBook(originalBook.getBytes());
		bookDto.setPublisher(bookForm.getPublisher());
		bookDto.setTitle(bookForm.getTitle());

		try {
			flag = bookService.addBook(bookDto);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "save-book";
		}

		if (flag == true)
			return "book-added";
		return "save-book";

	}
}
