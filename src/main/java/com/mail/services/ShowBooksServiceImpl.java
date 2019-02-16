package com.mail.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.bo.ShowBookBo;
import com.mail.dao.ShowBooksDaoImpl;
import com.mail.dto.ShowBooksDto;

import antlr.collections.List;

@Service
public class ShowBooksServiceImpl implements ShowBooksService {

	@Autowired
	private ShowBooksDaoImpl showBooks;

	@Override
	public ArrayList<ShowBooksDto> showBooks() {
		ArrayList<ShowBookBo> bookBos = showBooks.getBooksCover();
		ArrayList<ShowBooksDto> booksDtos = new ArrayList<>();

		for (ShowBookBo bo : bookBos) {
			ShowBooksDto booksDto = new ShowBooksDto();
			booksDto.setCovers(bo.getCover().toString());
			booksDtos.add(booksDto);
		}

		return booksDtos;
	}

}
