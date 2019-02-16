package com.mail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mail.bo.RegistrationVerificationBo;
import com.mail.services.RegistrationService;

@Controller
public class VerificationController {

	@Autowired
	private RegistrationService registrationService;
	private boolean flag = false;

	@RequestMapping(value = "/verification.htm", method = RequestMethod.GET)
	public String showVerification(@RequestParam("key") String key, @RequestParam("username") String username) {
		RegistrationVerificationBo registrationVerificationBo = null;

		registrationVerificationBo = new RegistrationVerificationBo();
		registrationVerificationBo.setKey(key);
		registrationVerificationBo.setUsername(username);

		flag = registrationService.verify(registrationVerificationBo);
		if (flag == true) {
			return "verification";
		} else {
			return "timeout";
		}
	}
}
