package com.mail.dao;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Repository;
import com.mail.bo.RegistrationBo;
import com.mail.bo.RegistrationVerificationBo;
import com.main.exceptions.RegistrationFailedException;

@Repository
public class RegistrationDao implements IRegistrationDao {
	private Logger logger = Logger.getLogger(RegistrationDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	MailSender mailSender;
	private final static String REGISTER_USER = "INSERT INTO `users` (`first_name`, `last_name`, `username`, `password`, `role_name`, `gender`, `dob`, `status`, `email`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String INSERT_KEY_AND_TIMESTAMP = "INSERT INTO `time` (`timestamp`, `key`, `username`) VALUES (?, ?, ?)";
	private final static String GET_TIMESTAMP_FOR_KEY = "SELECT timestamp FROM time where `key`=?";
	private final String CHECK_USERNAME = "select username from users where username=?";
	private final String UPDATE_USER_STATUS = "UPDATE `users` SET `status`='V' WHERE `username`=?";

	@Override
	public void addUser(RegistrationBo registrationBo) {
		try {
			if (logger.isDebugEnabled())
				logger.debug("Enter into addUser method to register a user");
			jdbcTemplate.update(REGISTER_USER, registrationBo.getFirstName(), registrationBo.getLastName(),
					registrationBo.getUsername(), registrationBo.getPassword(), registrationBo.getRollName(),
					registrationBo.getGender(), registrationBo.getDob(), registrationBo.getStatus(),
					registrationBo.getEmailAddress());
			if (logger.isDebugEnabled())
				logger.debug("Exit from addUser method");

		} catch (DataAccessException e) {
			logger.error("Registration Failed! ", e);
			throw new RegistrationFailedException();
		}
	}

	@Override
	public void saveTimeStamp(Timestamp timestamp, String key, String firstName) {
		if (logger.isDebugEnabled())
			logger.debug("Enter into saveTimeStamp method for user: " + firstName);

		jdbcTemplate.update(INSERT_KEY_AND_TIMESTAMP, timestamp, key, firstName);

		if (logger.isDebugEnabled())
			logger.debug("Exit from saveTimeStamp method for user: " + firstName);

	}

	@Override
	public Timestamp getTimeStamp(String key) {
		return jdbcTemplate.queryForObject(GET_TIMESTAMP_FOR_KEY, Timestamp.class, key);
	}

	@Override
	public void updateUserStatus(RegistrationVerificationBo registrationVerificationBo) {
		jdbcTemplate.update(UPDATE_USER_STATUS, registrationVerificationBo.getUsername());
		logger.info("User mail has been varified for username: " + registrationVerificationBo.getUsername());
	}

	@Override
	public boolean checkUserName(String username) {
		try {
			String user = jdbcTemplate.queryForObject(CHECK_USERNAME, String.class, username);
			if (user.length() != 0)
				return false;
			return true;

		} catch (DataAccessException e) {
			return true;
		}
	}
}
