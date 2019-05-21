package com.mail.dao;

import java.util.ArrayList;

import com.mail.bo.BookBo;

public interface SearchBarDAO {
	
	public ArrayList<BookBo> getBooksFromQuery(String query);
}
