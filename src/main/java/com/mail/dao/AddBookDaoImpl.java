package com.mail.dao;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mail.bo.BookBo;
import com.main.exceptions.BookInsertionFailedException;

@Repository
public class AddBookDaoImpl implements AddBookDao {
	private Logger logger = Logger.getLogger(AddBookDaoImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void saveBook(BookBo bookBo) {

		try {
			hibernateTemplate.save(bookBo);
		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.debug("failed to save book", e);
			throw new BookInsertionFailedException();

		}
	}
}
