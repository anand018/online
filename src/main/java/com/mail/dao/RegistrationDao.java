package com.mail.dao;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Repository;
import com.mail.bo.RegistrationBo;
import com.mail.bo.RegistrationVerificationBo;
import com.main.exceptions.RegistrationFailedException;

@Repository
public class RegistrationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	MailSender mailSender;
	private final static String REGISTER_USER = "INSERT INTO `udyog`.`users` (`first_name`, `last_name`, `username`, `password`, `role_name`, `gender`, `dob`, `status`, `email`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String INSERT_KEY_AND_TIMESTAMP = "INSERT INTO `udyog`.`time` (`timestamp`, `key`, `username`) VALUES (?, ?, ?)";
	private final static String GET_TIMESTAMP_FOR_KEY = "SELECT timestamp FROM udyog.time where `key`=?";
	private final String CHECK_USERNAME = "select username from users where username=?";
	private final String UPDATE_USER_STATUS = "UPDATE `udyog`.`users` SET `status`='V' WHERE `username`=?";

	public void addUser(RegistrationBo registrationBo) {
		try {
			jdbcTemplate.update(REGISTER_USER, registrationBo.getFirstName(), registrationBo.getLastName(),
					registrationBo.getUsername(), registrationBo.getPassword(), registrationBo.getRollName(),
					registrationBo.getGender(), registrationBo.getDob(), registrationBo.getStatus(),
					registrationBo.getEmailAddress());

		} catch (DataAccessException e) {
			throw new RegistrationFailedException();
		}
	}

	public void saveTimeStamp(Timestamp timestamp, String key, String firstName) {
		jdbcTemplate.update(INSERT_KEY_AND_TIMESTAMP, timestamp, key, firstName);
	}

	public Timestamp getTimeStamp(String key) {
		return jdbcTemplate.queryForObject(GET_TIMESTAMP_FOR_KEY, Timestamp.class, key);
	}

	public void updateUserStatus(RegistrationVerificationBo registrationVerificationBo) {
		jdbcTemplate.update(UPDATE_USER_STATUS, registrationVerificationBo.getUsername());
	}

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
