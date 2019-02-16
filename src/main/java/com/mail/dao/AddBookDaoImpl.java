package com.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mail.bo.AddBookBo;

@Repository
public class AddBookDaoImpl implements AddBookDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void saveBook(AddBookBo bookBo) {

		try {
			hibernateTemplate.save(bookBo);
		} catch (Exception e) {
			e.printStackTrace();
			// write logging
		}
	}
}
