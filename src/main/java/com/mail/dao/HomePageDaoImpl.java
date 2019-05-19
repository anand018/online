package com.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HomePageDaoImpl implements HomePageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String GETCUSTOMERFIRSTNAME = "SELECT first_name from users WHERE username = ?";

	@Override
	public String getCustomerFirstName(String username) {
		return jdbcTemplate.queryForObject(GETCUSTOMERFIRSTNAME, String.class, username);
	}

	@Override
	public void getJoiningDate() {

	}

}
