package com.mail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.dao.HomePageDao;

@Service
public class HomePageServiceImpl implements HomePageService {

	@Autowired
	private HomePageDao homePageDao;

	@Override
	public void showJoiningDate() {

	}

	@Override
	public String getCustomerFirstName(String username) {
		return homePageDao.getCustomerFirstName(username);

	}

}
