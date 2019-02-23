package com.mail.services;

import com.mail.bo.RegistrationVerificationBo;
import com.mail.dto.RegisterDto;

public interface IRegistrationService {

	public boolean registerUser(RegisterDto registerDto);

	public void saveTimeStampAndSendMail(RegisterDto registerDto);

	public boolean verify(RegistrationVerificationBo registrationVerificationBo);

}
