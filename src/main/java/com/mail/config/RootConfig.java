package com.mail.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.main.exceptions.RegistrationFailedException;

@Configuration
@ComponentScan("com.mail.dao, com.mail.services, com.mail.annotations, com.mail.config")
@PropertySource(value = { "classpath:application.properties" })
public class RootConfig {
	private static final Logger logger = Logger.getLogger(RootConfig.class);

	@Bean
	public MailSender mailSender() {

		if (logger.isDebugEnabled())
			logger.debug("Entered into mailSender method");

		Properties props = null;
		JavaMailSenderImpl mailSender = null;

		props = new Properties();

		try {
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setUsername("anandpsingh7@gmail.com");
			mailSender.setPassword("dyp34bs6519");
			mailSender.setJavaMailProperties(props);

			if (logger.isDebugEnabled())
				logger.debug("Exit mailSender method");

			return mailSender;
		} catch (Exception e) {

			if (logger.isDebugEnabled()) {
				logger.error("Configuration problem ", e);
			}

			throw new RegistrationFailedException();

		}
	}

	@Bean
	public SimpleMailMessage simpleMailMessage() {
		return new SimpleMailMessage();
	}

	@Bean
	public BCryptPasswordEncoder bCrypt() {
		return new BCryptPasswordEncoder();
	}
}
