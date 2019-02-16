package com.mail.controllers;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mail.dto.RegisterDto;
import com.mail.form.RegisterForm;
import com.mail.services.RegistrationService;

@Controller
@RequestMapping("/register.htm")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping
	public void showRegister(ModelMap map) {
		RegisterForm form = null;

		form = new RegisterForm();
		map.addAttribute("registerForm", form);

	}

	@PostMapping
	public String register(@ModelAttribute("registerForm") @Valid RegisterForm registerForm, BindingResult errors) {
		if (errors.hasErrors())
			return "register";

		RegisterDto registerDto = null;
		registerDto = new RegisterDto();
		BeanUtils.copyProperties(registerForm, registerDto);

		boolean flag = registrationService.registerUser(registerDto);

		if (flag == true)
			return "verify";
		return "failure";
	}
}
