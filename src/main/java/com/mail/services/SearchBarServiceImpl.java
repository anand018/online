package com.mail.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.bo.BookBo;
import com.mail.dao.SearchBarDAO;
import com.mail.dto.ShowBooksDto;

@Service
public class SearchBarServiceImpl implements SearchBarService{

	@Autowired
	SearchBarDAO searchBarDAO;
	
	@Override
	public ArrayList<ShowBooksDto> getBooksFromQuery(String query) {
	
		ArrayList<BookBo> bookBos = searchBarDAO.getBooksFromQuery(query);
		ArrayList<ShowBooksDto> booksDtos = new ArrayList<>();

		for (BookBo bo : bookBos) {
			ShowBooksDto booksDto = new ShowBooksDto();
			byte[] encodeBase64 = Base64.encodeBase64(bo.getCoverPage());
			String base64Encoded = "";
			try {
				base64Encoded = new String(encodeBase64, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			booksDto.setCovers(base64Encoded);
			booksDto.setEdition(bo.getEdition());
			booksDto.setPublisher(bo.getPublisher());
			booksDto.setTitle(bo.getTitle());
			booksDtos.add(booksDto);
		}

		return booksDtos;
	}
}
