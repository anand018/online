package com.mail.services;

import java.sql.Timestamp;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mail.bo.RegistrationBo;
import com.mail.bo.RegistrationVerificationBo;
import com.mail.dao.RegistrationDao;
import com.mail.dto.RegisterDto;
import com.main.exceptions.RegistrationFailedException;

@Service
@EnableTransactionManagement
public class RegistrationService implements IRegistrationService {
	private static final Logger logger = Logger.getLogger(RegistrationService.class);

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RegistrationDao registrationDao;
	@Autowired
	private SimpleMailMessage mailMessage;
	@Autowired
	private MailSender mailSender;
	@Autowired
	private Environment env;

	@Override
	public boolean registerUser(RegisterDto registerDto) {
		RegistrationBo registrationBo;
		registrationBo = new RegistrationBo();

		if (logger.isInfoEnabled())
			logger.info("Enter into registerUser method");

		try {
			if (registerDto.getPassword().equals(registerDto.getRePassword())) {
				BeanUtils.copyProperties(registerDto, registrationBo);
				registrationBo.setRollName("customer");
				registrationBo.setStatus("R");

				String encryptedPassword = bCryptPasswordEncoder.encode(registerDto.getPassword());
				registrationBo.setPassword(encryptedPassword);

				registrationDao.addUser(registrationBo);

				if (logger.isInfoEnabled())
					logger.info("new user added successfully");

				saveTimeStampAndSendMail(registerDto);
				if (logger.isInfoEnabled())
					logger.info("one varification mail has been sent successfully to user" + registerDto.getUsername());
				return true;

			} else {
				logger.error(this.getClass().getSimpleName() + ": Registration failed for user: "
						+ registerDto.getUsername());
				return false;
			}

		} catch (RegistrationFailedException e) {
			logger.error(this.getClass().getSimpleName() + ": Registration failed for user: "
					+ registerDto.getUsername() + " " + e);
			return false;
		}
	}

	@Override
	public void saveTimeStampAndSendMail(RegisterDto registerDto) {
		String key = null;

		mailMessage.setTo(registerDto.getEmailAddress());
		mailMessage.setFrom("virtusa@norepy.com");
		mailMessage.setSubject("varification mail");
		key = UUID.randomUUID().toString();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		registrationDao.saveTimeStamp(timestamp, key, registerDto.getUsername());

		String URL = env.getRequiredProperty("app.url") + key + "&" + "username=" + registerDto.getUsername();

		mailMessage.setText("please click on above link to varify your account. \n \n " + URL);
		mailSender.send(mailMessage);
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean verify(RegistrationVerificationBo registrationVerificationBo) {
		Timestamp originalTimeStamp = registrationDao.getTimeStamp(registrationVerificationBo.getKey());
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		int timeout = 5;

		if (currentTimeStamp.getMinutes() - originalTimeStamp.getMinutes() <= timeout) {
			registrationDao.updateUserStatus(registrationVerificationBo);
			return true;
		}
		return false;
	}
}
