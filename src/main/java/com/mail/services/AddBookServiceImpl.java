package com.mail.services;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.bo.AddBookBo;
import com.mail.dao.AddBookDaoImpl;
import com.mail.dto.AddBookDto;
import com.main.exceptions.BookInsertionFailedException;

@Service
public class AddBookServiceImpl implements AddBookService {
	private static Logger logger = Logger.getLogger(AddBookServiceImpl.class);

	@Autowired
	private AddBookDaoImpl bookDao;

	@Override
	public boolean addBook(AddBookDto bookDto) {
		boolean flag = false;
		AddBookBo bookBo;

		bookBo = new AddBookBo();

		try {
			if (logger.isInfoEnabled())
				logger.info("Enter into addBook method");

			BeanUtils.copyProperties(bookDto, bookBo);
			bookDao.saveBook(bookBo);
			flag = true;

			if (logger.isInfoEnabled())
				logger.info("Returning from addBook Method");
			return flag;

		} catch (Exception e) {
			logger.error("Failed to save book: " + e);
			return flag;
		}
	}
}
