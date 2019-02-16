package com.mail.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HomePageDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void getJoiningDate() {
		
		
	}
}
