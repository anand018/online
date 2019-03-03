package com.mail.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mail.bo.BookBo;
import com.mail.dao.ShowBooksDao;
import com.mail.dto.ShowBooksDto;

@Service
public class ShowBooksServiceImpl implements ShowBooksService {

	@Autowired
	private ShowBooksDao showBooks;

	@Override
	@Transactional(readOnly = true)
	public ArrayList<ShowBooksDto> showBooks() {
		ArrayList<BookBo> bookBos = showBooks.getBooksCover();
		ArrayList<ShowBooksDto> booksDtos = new ArrayList<>();

		for (BookBo bo : bookBos) {
			ShowBooksDto booksDto = new ShowBooksDto();
			booksDto.setCovers(bo.getCoverPage());
			booksDto.setEdition(bo.getEdition());
			booksDto.setPublisher(bo.getPublisher());
			booksDto.setTitle(bo.getTitle());
			booksDtos.add(booksDto);
		}

		
		return booksDtos;
	}

}
