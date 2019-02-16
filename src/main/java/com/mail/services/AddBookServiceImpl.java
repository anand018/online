package com.mail.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.bo.AddBookBo;
import com.mail.dao.AddBookDaoImpl;
import com.mail.dto.AddBookDto;

@Service
public class AddBookServiceImpl implements AddBookService {

	@Autowired
	private AddBookDaoImpl bookDao;

	@Override
	public boolean addBook(AddBookDto bookDto) {
		boolean flag = false;
		AddBookBo bookBo;

		bookBo = new AddBookBo();

		try {

			BeanUtils.copyProperties(bookDto, bookBo);
			bookDao.saveBook(bookBo);
			flag = true;
			return flag;

		} catch (Exception e) {
			e.printStackTrace();
			return flag;
			// TODO: handle exception
		}
	}
}
