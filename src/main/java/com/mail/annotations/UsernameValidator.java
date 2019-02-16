package com.mail.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.mail.dao.RegistrationDao;

public class UsernameValidator implements ConstraintValidator<Username, String> {
	private static final Logger logger = Logger.getLogger(UsernameValidator.class);
	
	@Autowired
	RegistrationDao registrationDao;
	boolean flag;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(logger.isDebugEnabled())
			logger.debug("Entered into isValid method");

		flag = registrationDao.checkUserName(username);
		
		if(logger.isDebugEnabled())
			logger.debug("Exit from isValid method");
		return flag;
	}
}
