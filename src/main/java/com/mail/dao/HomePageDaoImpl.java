package com.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HomePageDaoImpl implements HomePageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void getJoiningDate() {

	}
}
